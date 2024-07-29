package com.example.restoapp.ui.theme.screen
import android.text.Layout
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restoapp.data.Destination
import com.example.restoapp.data.LocalData
import com.example.restoapp.model.Food


@Composable
fun DetailScreen(modifier: Modifier = Modifier,navController: NavController, foodId: Int) {
    val food = LocalData.getFood(foodId)
    Column(
        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(modifier = Modifier.fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally,)
            {
                Box(modifier = modifier){
                    Image(painter = painterResource(id = food!!.imageId), contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop)

                    IconButton(onClick = {navController.navigate(Destination.Menu.route)}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "back")


                    }
            }


                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),) {
                    Text(text = LocalContext.current.getString(food!!.name),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = "$${LocalContext.current.getString(food.price)}",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(8.dp))
                    Text(text = LocalContext.current.getString(food.description),
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyMedium)

                }

                Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {  }) {
                Text(text = "Place a Order")

            }

        }



    }
}