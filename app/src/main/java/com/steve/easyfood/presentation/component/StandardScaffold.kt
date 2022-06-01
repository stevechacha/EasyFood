package com.steve.easyfood.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.steve.easyfood.domain.model.BottomNavItem
import com.steve.easyfood.ui.theme.darkGreen
import com.steve.easyfood.ui.theme.primaryGray
import com.steve.easyfood.ui.theme.primaryPink


@Composable
fun StandardScaffold(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Menu,
        BottomNavItem.More
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation(

                    backgroundColor = darkGreen,
                    contentColor = Color.Black,
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))

                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id=item.icon),
                                    contentDescription = item.title,
                                )
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    fontSize = 9.sp
                                )
                            },
                            selectedContentColor = Color.White,
                            unselectedContentColor = Color.Black,
                            alwaysShowLabel = true,
                            selected = currentDestination?.route?.contains(item.destination.route) == true,
                            onClick = {
                                navController.navigate(item.destination.route) {
                                    navController.graph.startDestinationRoute?.let { screen_route ->
                                        popUpTo(screen_route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}