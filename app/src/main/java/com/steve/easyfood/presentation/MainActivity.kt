package com.steve.easyfood.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.steve.easyfood.presentation.component.StandardScaffold
import com.steve.easyfood.presentation.destinations.*
import com.steve.easyfood.presentation.ui.theme.EasyFoodTheme
import com.steve.easyfood.presentation.ui.theme.darkGreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyFoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = darkGreen
                ) {
                    val navController = rememberAnimatedNavController()
                    val navHostEngine = rememberNavHostEngine()
                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route


                    StandardScaffold(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            SearchScreenDestination.route,
                            MenuDestination.route,
                            LocationScreenDestination.route
                        )

                    ){ innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)){
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }

                    }
                }
            }
        }
    }
}

