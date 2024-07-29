package com.example.restoapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.restoapp.data.Destination
import com.example.restoapp.ui.theme.RestoAppTheme
import com.example.restoapp.ui.theme.screen.DetailGallery
import com.example.restoapp.ui.theme.screen.DetailScreen
import com.example.restoapp.ui.theme.screen.FoodViewModel
import com.example.restoapp.ui.theme.screen.GalleryScreen
import com.example.restoapp.ui.theme.screen.HomeScreen
import com.example.restoapp.ui.theme.screen.MenuScreen
import com.example.restoapp.ui.theme.screen.StartScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestoAppTheme {

                Surface(modifier = Modifier , color = MaterialTheme.colorScheme.background) {
                   val viewModel: FoodViewModel = viewModel()
                    var showComposable by rememberSaveable { mutableStateOf(viewModel.showComposable) }
                    val navController = rememberNavController()


                    StartScreen(onClick = {showComposable = true})

                    if (showComposable) {
                       BottomNavigations(navController = navController)

                    }

                }

            }


        }
    }

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigations(navController: NavHostController, modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.safeDrawingPadding(),

        bottomBar = {
            NavigationBar {
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry.value?.destination

                NavigationBarItem(selected = currentRoute?.route == Destination.Home.route,
                    onClick = { navController.navigate(Destination.Home.route) },
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text(text = Destination.Home.route) })

                NavigationBarItem(selected = currentRoute?.route == Destination.Menu.route,
                    onClick = { navController.navigate(Destination.Menu.route) },
                    icon = { Icon(Icons.Filled.Menu, contentDescription = null) },
                    label = { Text(text = Destination.Menu.route) })

                NavigationBarItem(selected = currentRoute?.route == Destination.Gallery.route,
                    onClick = { navController.navigate(Destination.Gallery.route) },
                    icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                    label = { Text(text = Destination.Gallery.route) })
            }
        }
    ) {
        NavHost(navController = navController, Destination.Home.route) {
            composable(Destination.Home.route) { HomeScreen(navController) }
            composable(Destination.Menu.route) { MenuScreen(navController) }
            composable(Destination.Gallery.route) { GalleryScreen(navController) }
            // detail menu
            composable(Destination.DetailScreen.route) { navBackstackEntry ->
                val foodId = navBackstackEntry.arguments?.getString("foodId")
                if (foodId == null)
                    Toast.makeText(ctx,"food id is require", Toast.LENGTH_SHORT).show()
                else
                    DetailScreen(navController = navController, foodId = foodId.toInt())

            }
            // detail gallery
            composable(Destination.DetailGallery.route){ navBackStackEntry ->  
                val imageGalleryId = navBackStackEntry.arguments?.getString("imageGalleryId")
                if (imageGalleryId == null)
                    Toast.makeText(context,"image id is require", Toast.LENGTH_SHORT).show()
                else
                    DetailGallery(navController = navController, imageGalleryId = imageGalleryId.toInt())
            }
        }
    }
}





