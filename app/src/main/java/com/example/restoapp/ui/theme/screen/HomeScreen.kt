package com.example.restoapp.ui.theme.screen

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restoapp.R
import com.example.restoapp.data.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
        Scaffold(topBar = { HomeTopBar()}) {  it ->

            Column( modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                HomeBody(navController = navController)

            }

        }


    }






@Composable
fun HomeBody(navController: NavController, modifier: Modifier = Modifier) {
    val image1 = painterResource(id = R.drawable.home1)
    val image2 = painterResource(id = R.drawable.home2)
    val image3 = painterResource(id = R.drawable.home3)
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 10.dp, bottom = 100.dp),
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth(1f)
                   // .size(width = 360.dp, height = 250.dp)
            ) {
                Box(
                    modifier = Modifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.homeimage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Pirince restaurant",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.BottomStart),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                    )
                }

            }
        Column(modifier = Modifier.padding(8.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text(text = "Welcome to Prince Restaurant", style = MaterialTheme.typography.headlineSmall)
            Text(text = "Best Foods", style = MaterialTheme.typography.displayMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Located In Waterloo, Iowa Prince restaurant serves Authentic Foods From Africa", style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "We have everything you need to satisfy your hunger and some special African foods that you will like and enjoy to eat", style = MaterialTheme.typography.bodyLarge,textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {navController.navigate(Destination.Menu.route)}) {
                Text(text = "Order Now")
            }
        }
        Column(modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Located In Waterloo, Iowa Prince restaurant serves Authentic Foods From Africa", style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
            ImageCard(image1)
            Text(text = "We have everything you need to satisfy your hunger and some special African foods that you will like and enjoy to eat", style = MaterialTheme.typography.bodyLarge,textAlign = TextAlign.Center)
            ImageCard(image2)
            Text(text = "We have everything you need to satisfy your hunger and some special African foods that you will like and enjoy to eat", style = MaterialTheme.typography.bodyLarge,textAlign = TextAlign.Center)
            ImageCard(image3)

        }
        RestaurantAddress()



    }


}

@Composable
fun ImageCard( image: Painter) {
    Spacer(modifier = Modifier.height(10.dp))
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        modifier = Modifier
            .size(width = 360.dp, height = 300.dp)
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .aspectRatio(1f)
        )

    }
    Spacer(modifier = Modifier.height(10.dp))
}
@Composable
fun RestaurantAddress(modifier: Modifier = Modifier){

    Column(
        modifier
            .padding(30.dp)
            .fillMaxWidth(1f), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "123 Demo Street", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Waterloo, Iowa", fontSize = 18.sp, style = MaterialTheme.typography.bodyLarge,modifier = Modifier.padding(10.dp))
        Button(onClick = {}) {
            Text(text = "Get Directions")
        }
        Row {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = "Monday - Thursday")
                Text(text = "5 am - 10 pm")
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = "Friday - Sunday")
                Text(text = "5 am - 12 pm")

            }
        }
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(modifier: Modifier = Modifier){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(  colors = TopAppBarDefaults.topAppBarColors(
        titleContentColor = MaterialTheme.colorScheme.primary,
    ),title = {

            Text(text = " Prince Restaurant",
                style = MaterialTheme.typography.headlineSmall,)

        } ,modifier = modifier ,scrollBehavior = scrollBehavior)

}



