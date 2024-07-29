package com.example.restoapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restoapp.R
import java.time.format.TextStyle

@Composable
fun StartScreen(modifier: Modifier = Modifier, onClick: () -> Unit ) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

            ColumnPage1(
                welcome = stringResource(id = R.string.title2),
                des = stringResource(id = R.string.welcome),
                image = R.drawable.acceilimage,
                onClick = onClick
            )


        }
    }



    @Composable
    fun ColumnPage1(welcome: String, des: String, image: Int, onClick: () -> Unit,modifier: Modifier = Modifier){
        Column(
            modifier = Modifier
                .fillMaxSize()

                .padding(0.dp)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = welcome,
                modifier = Modifier,
                textAlign = TextAlign.Center,
                style =  MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace


            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = image), contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = des, modifier = Modifier
                    .padding(10.dp),
                textAlign = TextAlign.Center,

            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick =  onClick ) {
                Text(text = stringResource(id = R.string.start))
            }
        }

    }



