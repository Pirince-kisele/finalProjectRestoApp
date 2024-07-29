package com.example.restoapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restoapp.data.Destination
import com.example.restoapp.data.GalleryData
import com.example.restoapp.data.LocalData
import com.example.restoapp.model.Food
import com.example.restoapp.model.Gallery


@Composable
fun GalleryScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
        .padding(bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {

        GalleryList(navController, galleryList = GalleryData.getGalleryImage())

    }
}

@Composable
fun GalleryItemCart(navController: NavController, gallery: Gallery, modifier: Modifier = Modifier, onClick: () -> Unit){


    ElevatedCard(onClick =  onClick ,
        modifier = Modifier
            .fillMaxWidth(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp))
    {
        Image(painter = painterResource(id = gallery.imageGallery),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(1f)
                .aspectRatio(1f)

            )
    }

    Spacer(modifier = Modifier.height(10.dp))

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryTopBar(modifier: Modifier = Modifier){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(  colors = TopAppBarDefaults.topAppBarColors(
        titleContentColor = MaterialTheme.colorScheme.primary,
    ),title = {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center) {

            Text(text = "Gallery",
                style = MaterialTheme.typography.headlineSmall,
            )

        }

    }, modifier = modifier ,scrollBehavior = scrollBehavior)

}


@Composable
fun GalleryList(navController: NavController, modifier: Modifier = Modifier, galleryList:List<Gallery>) {
    Scaffold(topBar = { GalleryTopBar()}) { it ->

        LazyVerticalStaggeredGrid(modifier = Modifier, contentPadding = it,
           columns = StaggeredGridCells.Adaptive(200.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(1.dp) ) {

            items(galleryList) { gallery ->
                GalleryItemCart(navController = navController, onClick = {
                    val route = Destination.DetailGallery.createRouteGallery(imageGalleryId = gallery.id)
                    navController.navigate(route)
                }, gallery = gallery)

            }
        }
    }

}

