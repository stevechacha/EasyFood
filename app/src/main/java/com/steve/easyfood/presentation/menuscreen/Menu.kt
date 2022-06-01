package com.steve.easyfood.presentation.menuscreen

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Forward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.presentation.component.StandardToolbar
import com.steve.easyfood.presentation.mainscreen.MainScreen
import com.steve.easyfood.ui.theme.darkGreen

@Composable
@Destination
fun Menu(
    navigator: DestinationsNavigator
) {
    Column (
        modifier = Modifier.fillMaxSize()
            .background(darkGreen)
    ) {
        StandardToolbar(
            navigator =navigator,
            title = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(text = "Location")
                    Text(text = "location2")
                }
            },
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth()
        )
        // Content
        MenuContScreen()

    }

}

@Composable
fun MenuContScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(Color.White)
            .padding(10.dp)
    ){
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()


    }

}

@Composable
fun CardItem() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp))
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp),
            shape= RoundedCornerShape(20.dp)

        ){
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background) ,
                    contentDescription =  null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Column (
                    modifier = Modifier
                        .width(250.dp)
                        .padding(10.dp)
                ){
                    Text(text = "Username", maxLines = 1,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Description",
                        fontSize = 12.sp,
                        maxLines = 3
                    )
                }
                Image(imageVector = Icons.Filled.Forward,
                    contentDescription = null
                )
                
            }

        }

    }

}




