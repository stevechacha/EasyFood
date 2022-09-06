package com.steve.easyfood.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.presentation.menuscreen.CardItem
import com.steve.easyfood.presentation.ui.theme.darkGreen
import com.steve.easyfood.R
import com.steve.easyfood.presentation.component.SearchToolbar

@Composable
@Destination
fun SearchScreen(
    navigator: DestinationsNavigator
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen)
    ) {
        Card(
            elevation = 4.dp,
        ) {
            Image(painter = painterResource(id = R.drawable.foddd),
                contentDescription = null,
            )
            Column() {
                SearchToolbar(
                    navigator =navigator,
                    title = {
                        Text(text = "SearchToolBar")
                    },
                    navActions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector =Icons.Filled.Search
                                , contentDescription = null
                            )
                        }

                    },
                    showBackArrow = true,
                    modifier = Modifier.fillMaxWidth()
                )


                Spacer(modifier = Modifier.height(120.dp))


                //Content
                Column(
                    modifier = Modifier
                        .weight(0.50f)
                        .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                        .background(darkGreen)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp)
                    ) {
                        Text(text = "Choose Burger")
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Simba Super Market")
                        Spacer(modifier = Modifier.height(25.dp))

                        // Rating
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(text = "Rating")
                            Text(text = "Minimum Order")
                            Text(text = "Ksh.4000")
                            Text(text = "43 reviews")

                        }
                        //Selection Lazy
                        NestedScroll()
                    }
                    TimesCard()
                }
            }

        }

    }
}
@Composable
fun TimesCard() {
    Column(
        modifier = Modifier
            .height(500.dp)
            .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
            .background(Color.White)
    ) {
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()
        Spacer(modifier = Modifier.height(5.dp))
        CardItem()
    }
}

@Composable
fun NestedScroll() {

    val  items = listOf("Bread", "Snacks & Pastries","Cokes & Mutfl")
    var selectedGener by remember { mutableStateOf("") }

    LazyRow(){
                    items(count = items.size){
                        FoodCategory(
                            items = items[it],
                            selected = items[it] == selectedGener
                        ){
                            selectedGener = items[it]
                        }
                    }


    }

}



