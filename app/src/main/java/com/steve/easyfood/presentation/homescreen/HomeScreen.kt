package com.steve.easyfood.presentation.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.presentation.component.StandardToolbar
import com.steve.easyfood.presentation.ui.theme.darkGreen


@Composable
@Destination
fun HomeScreen(
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
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text(
                       text = "Location",
                       style = MaterialTheme.typography.body1
                   )
                   Text(
                       text = "location2",
                       style = MaterialTheme.typography.body1
                   )
               }
           },
           showBackArrow = true,
           modifier = Modifier.fillMaxWidth()
       )
        // Content
        MainScreen()

    }
}

@Composable
fun MainScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(Color.White)
            .padding(10.dp)
    ){
            CardRow()
            CardRow2()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardRow() {
    val list = listOf<String>("Meru","Meru")

    Row {
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            content = {
                items(list.size){ index ->
                    Card(
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .height(170.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        elevation = 8.dp)
                    {
                        Column (
                            modifier= Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.foddd),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                            )
                            Text(
                                text = list[index],
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                style = MaterialTheme.typography.body2,
                                color = Color.DarkGray
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){

                                Text(text = "Ksh.4000",
                                    fontSize = 18.sp,
                                    color = darkGreen,
                                    maxLines = 1,
                                    style = MaterialTheme.typography.body1
                                )

                                Icon(
                                    Icons.Filled.Add,"Add",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(darkGreen)
                                )
                            }
                        }
                    }
                }
            }
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardRow2() {
    Column {
        Text(text = "Browser by Categories",
            color= Color.Black,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(5.dp)

        )
        val list = listOf<String>("Samosa","Pizza","Matumbo","Meat","Chapati","Mengo",)

        LazyVerticalGrid(cells = GridCells.Fixed(2),
            content = {
                items(list.size){ index ->

                    Card(
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .height(170.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        elevation = 8.dp)
                    {
                        Column (
                            modifier= Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.foddd),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
                            Text(
                                text = list[index],
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.DarkGray
                            )
                            Row(
                                modifier= Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){

                                Text(text = "Ksh.4000",
                                    fontSize = 18.sp,
                                    color = darkGreen,
                                    maxLines = 1,
                                )

                                Icon(
                                    Icons.Filled.Add,"Add",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(darkGreen)
                                )

                            }

                        }


                    }

                }


            }

        )
    }
}
