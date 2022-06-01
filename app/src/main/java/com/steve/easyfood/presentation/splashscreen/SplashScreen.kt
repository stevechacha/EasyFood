package com.steve.easyfood.presentation.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.presentation.destinations.LoginScreenDestination
import com.steve.easyfood.presentation.destinations.WelcomeScreenDestination
import com.steve.easyfood.presentation.welcomescreen.WelcomeScreen
import com.steve.easyfood.ui.theme.darkGreen
import kotlinx.coroutines.delay

@Composable
@Destination(start = true)
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Set Navigation
        delay(3000L)
        navigator.popBackStack()
        navigator.navigate(WelcomeScreenDestination)


    }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(darkGreen)
    ) {
        
        Image(
            modifier= Modifier
                .fillMaxSize()
                .padding(100.dp)
            ,
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "app logo")

        Spacer(modifier = Modifier.height(1.dp))
        Text(text = "EasyFood", fontSize = 20.sp)
        
    }

}


