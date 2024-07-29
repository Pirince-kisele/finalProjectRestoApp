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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.restoapp.data.Destination
import com.example.restoapp.data.GalleryData



@Composable
fun DetailGallery(modifier: Modifier = Modifier,
                  navController: NavController,
                  imageGalleryId: Int ){
    val gallery = GalleryData.getGallery(imageGalleryId)

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0A0101)))
    {

        Row( modifier = Modifier
            .fillMaxWidth()
            .height(120.dp))
        {
            IconButton(onClick = {navController.navigate(Destination.Gallery.route) }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "back",
                    modifier = Modifier, tint = Color(0xffffffff))
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

        Column(modifier = Modifier.fillMaxWidth(1f)) {
            Image(painter = painterResource(id = gallery!!.imageGallery),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop)

        }

    }


}