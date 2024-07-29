package com.example.restoapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restoapp.R
import com.example.restoapp.data.Destination
import com.example.restoapp.data.LocalData
import com.example.restoapp.model.Food


@Composable
fun MenuScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp, bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        MenuList(navController, foodList = LocalData.getFoodData())

    }
}

@Composable
fun MenuItemCart(navController: NavController,food: Food,  modifier: Modifier = Modifier, onClick: () -> Unit){


        ElevatedCard(onClick =  onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp))
        {
          Image(painter = painterResource(id = food.imageId),
              contentDescription = null,
              Modifier
                  .fillMaxWidth()
                  .height(200.dp),
              contentScale = ContentScale.Crop)
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = LocalContext.current.getString(food.name),
                    style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                Text(text = "$${LocalContext.current.getString(food.price)}",
                    style = MaterialTheme.typography.bodyLarge)
                Text(text = LocalContext.current.getString(food.snippet),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyMedium)
            }
            }

    Spacer(modifier = Modifier.height(10.dp))

    }




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(modifier: Modifier = Modifier,

               isShowingDetail: Boolean = true
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(  colors = TopAppBarDefaults.topAppBarColors(
        titleContentColor = MaterialTheme.colorScheme.primary,
    ),title = {
        if (isShowingDetail) {
            Text(text = "Menu",
                style = MaterialTheme.typography.headlineSmall,
            )
        }


    }, modifier = modifier ,scrollBehavior = scrollBehavior)


}


@Composable
fun MenuList(navController: NavController, modifier: Modifier = Modifier, foodList:List<Food>) {
    Scaffold(topBar = { MenuTopBar()}) { it ->


        LazyColumn(modifier = Modifier.padding(top = 1.dp)
            , contentPadding = it) {
            items(foodList) { food ->
                MenuItemCart(navController = navController, onClick = {
                    val route = Destination.DetailScreen.createRoute(food.id)
                    navController.navigate(route)
                }, food = food)

            }
        }
    }
}