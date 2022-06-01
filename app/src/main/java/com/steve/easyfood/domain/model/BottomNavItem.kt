package com.steve.easyfood.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.steve.easyfood.R
import com.steve.easyfood.presentation.destinations.*

sealed class BottomNavItem(var title: String, var icon: Int, var destination: Destination) {
    object Home : BottomNavItem(
        title = "Home",
        icon = R.drawable.ic_home,
        destination = HomeScreenDestination
    )
    object Search: BottomNavItem(
        title = "Search",
        icon = R.drawable.ic_search,
        destination = SearchScreenDestination
    )
    object Menu: BottomNavItem(
        title = "Menu",
        icon = R.drawable.ic_menu,
        destination = MenuDestination
    )

    object More: BottomNavItem(
        title = "More",
        icon = R.drawable.ic_more,
        destination = LocationScreenDestination
    )
}