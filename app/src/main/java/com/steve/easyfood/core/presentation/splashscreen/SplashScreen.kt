package com.steve.easyfood.core.presentation.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.steve.easyfood.R
import com.steve.easyfood.core.presentation.common.theme.darkGreen
import com.steve.easyfood.destinations.WelcomeScreenDestination
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
                .width(200.dp)
                .height(200.dp)
//                .padding(100.dp)
            ,
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "app logo")

        Spacer(modifier = Modifier.height(1.dp))
        Text(text = "EasyFood",
            fontSize = 20.sp)
        
    }

}


