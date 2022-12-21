package com.steve.easyfood.feature_search.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.feature_menu.presentation.menuscreen.CardItem
import com.steve.easyfood.R
import com.steve.easyfood.core.presentation.common.theme.EasyFoodTheme
import com.steve.easyfood.core.presentation.common.theme.lightGray
import com.steve.easyfood.feature_search.presentation.component.SearchTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun SearchScreen(
    navigator: DestinationsNavigator
) {

    var search by remember { mutableStateOf("") }
    val items = listOf("Bread", "Snacks & Pastries", "Cokes & Mutfl")
    var selectedGener by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            SearchTopBar(
                onBackPressed = {}
            )

        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .fillMaxSize()
        ) {

            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(
                    topStart = 20.dp, topEnd = 20.dp,
                    bottomStart = 0.dp, bottomEnd = 0.dp
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Choose Burger",
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Simba Super Market",
                    )
                    Spacer(modifier = Modifier.height(8.dp))

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

                    LazyRow() {
                        items(count = items.size) {
                            FoodCategory(
                                items = items[it],
                                selected = items[it] == selectedGener
                            ) {
                                selectedGener = items[it]
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                }

                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier
                            .background(lightGray)
                            .padding(vertical = 10.dp)
                    ) {
                        LazyColumn(
                            contentPadding = PaddingValues(bottom = 8.dp)
                        ){
                            itemsIndexed((1..4).toList()){ index, coin ->
                                CardItem()
                                if (index == 3){
                                    Spacer(modifier = Modifier.height(5.dp))
                                }
                            }
                        }

                    }


                }



            }



        }



    }


}


@Composable
@Preview
fun PreviewSearch() {
    EasyFoodTheme {

    }
}


