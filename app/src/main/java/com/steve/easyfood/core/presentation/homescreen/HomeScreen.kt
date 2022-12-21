package com.steve.easyfood.core.presentation.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.core.presentation.domain.model.FoodItem
import com.steve.easyfood.core.presentation.component.StandardToolbar
import com.steve.easyfood.core.presentation.common.theme.darkGreen
import com.steve.easyfood.core.presentation.common.theme.lightGray


@Composable
@Destination
fun HomeScreen(
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
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text(
                       text = "Location",
                       textAlign = TextAlign.Center,
                   )
                   Text(
                       text = "location2",
                       textAlign = TextAlign.Center,
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
            .background(lightGray)
            .padding(10.dp)
    ){
            CardRow(
                FoodItem(
                    foodName = "FoodName",
                    price = 200.0,
                    onAdd = false
                )
            )
        Spacer(modifier = Modifier.height(5.dp))
            Categories()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardRow(
    foodItem: FoodItem,
    onAddClick: (Boolean) -> Unit = {}
) {
    val list = listOf<String>("Vegetables","Cheese Burger")
    val price = listOf<String>("4000","7000")

    Row {
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            content = {
                items(list.size){ index ->
                    Card(
                        colors = CardDefaults.cardColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(185.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .padding(5.dp),
                        elevation = CardDefaults.cardElevation(5.dp)
                    )
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
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = foodItem.foodName,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = Color.DarkGray,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                horizontalArrangement =
                                Arrangement.SpaceBetween
                            ){
                                Text(
                                    text = foodItem.price.toString(),
                                    maxLines = 1,
                                    fontSize = 15.sp,
                                    color = darkGreen,
                                )


                                Icon(
                                    Icons.Filled.Add,"Add",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(darkGreen),

                                )
                                Button(onClick = {

                                    onAddClick(foodItem.onAdd)
                                }) {

                                }
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
fun Categories() {
    Column {
        Text(text = "Browser by Categories",
            color= Color.Black,
            modifier = Modifier.padding(5.dp)

        )
        val list = listOf<String>("Pizza","Vegetables","Samosa & Chapati","Cocoa Juice","Pilau","Beef",)
        val price = listOf<String>("4500","1200","1000","3000","1500","2000",)

        LazyVerticalGrid(columns = GridCells.Fixed(2),
            content = {
                items(list.size){ index ->
                    Card(
                        colors = CardDefaults.cardColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(185.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(5.dp)
                    )
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
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = list[index],
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = Color.DarkGray,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                horizontalArrangement =
                                Arrangement.SpaceBetween
                            ){
                                Text(
                                    text = price[index],
                                    maxLines = 1,
                                    fontSize = 15.sp,
                                    color = darkGreen,
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
