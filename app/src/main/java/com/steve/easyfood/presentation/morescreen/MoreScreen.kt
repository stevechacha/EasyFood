package com.steve.easyfood.presentation.morescreen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.presentation.destinations.OrderScreenDestination
import com.steve.easyfood.presentation.ui.theme.SpaceLarge
import com.steve.easyfood.presentation.ui.theme.SpaceMedium
import com.steve.easyfood.presentation.ui.theme.darkGreen
import com.steve.easyfood.presentation.ui.theme.lightGray

@Composable
@Destination
fun LocationScreen(
    navigator: DestinationsNavigator,
    viewModel: MoreViewModel = hiltViewModel()
    ) {
    Column (modifier= Modifier
        .fillMaxSize()
        .background(lightGray)
        .padding(30.dp)
    ){
        Text(
            text = "Delivery Location",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }
        )
        
        Spacer(modifier = Modifier.height(50.dp))

        var textCity by remember { mutableStateOf("") }
        var textArea by remember { mutableStateOf("") }

        val color = Color.DarkGray.copy(alpha = 0.78F)
        val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = color,
            cursorColor = color,
            leadingIconColor = color,
            trailingIconColor = color,
            focusedBorderColor = Color.DarkGray,
            unfocusedBorderColor = color.copy(alpha = 0.5F),
            focusedLabelColor = Color.DarkGray,
            unfocusedLabelColor = color
        )

        TextField(
            value = textCity,
            onValueChange = { textCity = it},
            singleLine = true,
            colors = textFieldColors,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp, vertical =5.dp),
            label = {
                Text(text = stringResource(id = R.string.city),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,

                    )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Opacity,
                    contentDescription = null,
                    tint= Color.DarkGray
                )
            }


        )

        Spacer(modifier = Modifier.height(SpaceMedium))

        TextField(
            value = textArea,
            onValueChange = {textArea = it},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = textFieldColors,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp, vertical = 10.dp),
            label = {
                Text(text = stringResource(id = R.string.area),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,

                    )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.LocationCity,
                    contentDescription = null,
                    tint= Color.DarkGray
                )
            },

        )

        Spacer(modifier = Modifier.height(40.dp))


        Button(
            modifier= Modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = darkGreen
            ),
            onClick = {

            }
            ) {
            Icon( imageVector = Icons.Default.Verified,
                contentDescription ="Cart button icon",
                modifier = Modifier.size(20.dp))
            Text(
                text = "Confirm Location",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp))
        }
    }
}

