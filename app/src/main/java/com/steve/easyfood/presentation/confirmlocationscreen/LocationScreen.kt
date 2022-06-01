package com.steve.easyfood.presentation.confirmlocationscreen

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.presentation.component.SearchToolbar
import com.steve.easyfood.presentation.component.StandardTextFieldLocation
import com.steve.easyfood.presentation.component.StandardToolbar
import com.steve.easyfood.presentation.destinations.HomeScreenDestination
import com.steve.easyfood.presentation.destinations.OrderScreenDestination
import com.steve.easyfood.presentation.ui.theme.SpaceLarge
import com.steve.easyfood.presentation.ui.theme.SpaceMedium
import com.steve.easyfood.ui.theme.EasyFoodTheme
import com.steve.easyfood.ui.theme.darkGreen

@Composable
@Destination
fun LocationScreen(
    navigator: DestinationsNavigator,
    viewModel: LocationViewModel = hiltViewModel()
) {
    Column (modifier= Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(20.dp)
    ){

        Text(text = "Delivery Location",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.Black,
        modifier = Modifier.clickable {
            navigator.navigate(OrderScreenDestination)
        }
        )


        StandardTextFieldLocation(
            leadingIcon = {
                  Icons.Default.LocationCity
            },
            onValueChange ={

            },
        )
        
        
        Spacer(modifier = Modifier.height(SpaceMedium))

        var textCity by remember { mutableStateOf("") }

        TextField(
            value = textCity,
            onValueChange ={
                 textCity = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Opacity,
                    contentDescription = null)
            },
            label = {
                Text(text = "City")
            },
            placeholder = {
                Text(text = "City")

            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(SpaceMedium))

        var textArea by remember { mutableStateOf("") }

        TextField(
            value = textArea,
            onValueChange ={
                textArea = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationCity,
                    contentDescription = null)
            },
            label = {
                Text(text = "Area",
                    color = Color.DarkGray
                )
            },
            placeholder = {
                Text(text = "Area",
                    color = Color.Black
                )

            },
            modifier = Modifier
                .fillMaxWidth(),

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            )

        )
        
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier= Modifier
                .fillMaxWidth()
                .height(30.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = darkGreen
            ),
            onClick = {}
            ) {
            Icon( imageVector = Icons.Default.Verified,
                contentDescription ="Cart button icon",
                modifier = Modifier.size(20.dp))
            Text(text = "Confirm Location",Modifier.padding(start = 10.dp))
        }







    }



}

