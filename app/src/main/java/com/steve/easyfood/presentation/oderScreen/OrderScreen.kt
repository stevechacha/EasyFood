package com.steve.easyfood.presentation.oderScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.presentation.component.SearchToolbar
import com.steve.easyfood.presentation.component.StandardDiver
import com.steve.easyfood.presentation.destinations.LocationScreenDestination
import com.steve.easyfood.presentation.ui.theme.EasyFoodTheme
import com.steve.easyfood.presentation.ui.theme.darkGreen

@Composable
@Destination
fun OrderScreen(
    navigator: DestinationsNavigator
) {
    EasyFoodTheme {
            android.graphics.Color.parseColor("#121212")
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = darkGreen
        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(darkGreen)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SearchToolbar(
                    modifier = Modifier.fillMaxWidth(),
                    showBackArrow = true,
                    navigator = navigator,
                    title = {
                        Text(text = "Order",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                )
                Spacer(modifier = Modifier.height(25.dp))
                //Other Elements

                // First Element Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Text(text = "Short Title")

                    Text(text = "Amount")

                }

                StandardDiver()

                //Second Element

                Column(modifier = Modifier.align(Alignment.Start)
                ) {
                    TextButton(
                        onClick = {
                            // do something here
                            navigator.navigate(LocationScreenDestination)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Localized description",
                            modifier = Modifier.padding(end = 8.dp),
                            tint = Color.Black
                        )
                        Text(text = "Add Product"
                        )
                    }
                }

                StandardDiver()
                // Third Element
                TotalItem()
                StandardDiver()

                // Proceed Button
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.DarkGray,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                        .clip(RoundedCornerShape(30.dp))
                ) {

                    Text(text = "Proceed o Checkout")

                }
            }



        }
    }

}

@Composable
fun TotalItem() {
    Column {
        Text(text = "Total",
            modifier = Modifier.align(Alignment.Start)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Short Title")

            Text(text = "Amount")

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(text = "Short Title")

            Text(text = "Amount")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(text = "Short Title")

            Text(text = "Amount")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Short Title")

            Text(text = "Amount")

        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Comment(Optional)",
            modifier = Modifier.align(Alignment.Start)
        )
        Button(onClick = { /*TODO*/ }) {

        }

    }


}
