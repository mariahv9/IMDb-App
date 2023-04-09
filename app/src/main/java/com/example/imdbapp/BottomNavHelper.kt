package com.example.imdbapp

import androidx.annotation.DrawableRes

data class BottomNavHelper(
    val index: Int,
    val name: String,
    val route: String,
    @DrawableRes val icon_press: Int,
    @DrawableRes val icon_light: Int,
)

val bottomNavItems = listOf(
    BottomNavHelper(
        index = 0,
        name = "Home",
        route = "home_route",
        icon_press = R.drawable.icon_home,
        icon_light = R.drawable.icon_home_light,
    ),
    BottomNavHelper(
        index = 1,
        name = "Search",
        route = "search_route",
        icon_press = R.drawable.icon_search,
        icon_light = R.drawable.icon_search_light,
    ),
    BottomNavHelper(
        index = 2,
        name = "Play",
        route = "play_route",
        icon_press = R.drawable.icon_play,
        icon_light = R.drawable.icon_play_light,
    ),
    BottomNavHelper(
        index = 3,
        name = "Profile",
        route = "profile_route",
        icon_press = R.drawable.icon_user,
        icon_light = R.drawable.icon_user_light,
    )
)
