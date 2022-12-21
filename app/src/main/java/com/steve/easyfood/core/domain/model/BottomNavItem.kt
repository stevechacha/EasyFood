package com.steve.easyfood.core.domain.model

import com.steve.easyfood.R
import com.steve.easyfood.destinations.*

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