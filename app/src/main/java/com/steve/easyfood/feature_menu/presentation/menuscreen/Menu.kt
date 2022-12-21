package com.steve.easyfood.feature_menu.presentation.menuscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forward
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.core.presentation.component.StandardToolbar
import com.steve.easyfood.core.presentation.common.theme.darkGreen
import com.steve.easyfood.core.presentation.common.theme.lightGray

@Composable
@Destination
fun Menu(
    navigator: DestinationsNavigator
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
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
                    Text(text = "Location",
                        textAlign = TextAlign.Center,

                    )
//                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "location",
                        textAlign = TextAlign.Center,

                    )
                }
            },
            showBackArrow = true,
            modifier = Modifier
                .fillMaxWidth()
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
            .clip(RoundedCornerShape(topStart = 35.  dp, topEnd = 35.dp))
            .background(Color.White)
            .padding(10.dp)
    ){
        LazyColumn{
            itemsIndexed((1..6).toList()){ index, coin ->
                CardItem()

                if (index == 5){
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

    }

}

@Preview
@Composable
fun CardItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp)
        ,
            shape= RoundedCornerShape(20.dp)

        ){
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

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
                    Text(
                        text = "Username" ,
                        maxLines = 1,
                        color =Color.Black
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Description",
                        maxLines = 3,
                        color =Color.Black
                    )
                }
                Image(imageVector = Icons.Filled.Forward,
                    contentDescription = null
                )
                
            }

        }

}



