package com.steve.easyfood.presentation.welcomescreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.presentation.destinations.LoginScreenDestination
import com.steve.easyfood.presentation.ui.theme.darkGreen

@Composable
@Destination
fun WelcomeScreen(
    navigator: DestinationsNavigator
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
            .fillMaxSize()
            .background(darkGreen)){

        Image(
            modifier= Modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = null )

        Text(
            text ="We delivery your food at your\n" +
                "   doorstep at the best time",
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = FontFamily.Serif

        )
        Spacer(modifier = Modifier.height(14.dp))

        Button(
            shape= RoundedCornerShape(50.dp),
            modifier= Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(
                    start = 50.dp,
                    end = 50.dp

                )
            ,
            colors = ButtonDefaults.buttonColors(contentColor = Color.Red, backgroundColor = Color.White),
            onClick = {
                navigator.navigate(LoginScreenDestination)
            }
        ) {
            Text(
                text = "Get Started",
                color = darkGreen,
                fontSize = 20.sp,
                style = MaterialTheme.typography.body2
            )
        }


    }
    
}