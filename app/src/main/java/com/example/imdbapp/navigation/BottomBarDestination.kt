package com.example.imdbapp.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.imdbapp.ui.screen.HomeScreen
import com.example.imdbapp.ui.screen.PlayScreen
import com.example.imdbapp.ui.screen.ProfileScreen
import com.example.imdbapp.ui.screen.SearchScreen

object HomeDestination : NavegationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

object SearchDestination : NavegationDestination {
    override val route: String = "search_route"
    override val destination: String = "search_destination"
}

object PlayDestination : NavegationDestination {
    override val route: String = "play_route"
    override val destination: String = "play_destination"
}

object ProfileDestination : NavegationDestination {
    override val route: String = "profile_route"
    override val destination: String = "profile_destination"
}

fun NavGraphBuilder.bottomGraph(navController: NavController) {
    composable(route = HomeDestination.route) {
        HomeScreen(navController, movieViewModel = hiltViewModel())
    }

    composable(route = SearchDestination.route) {
        SearchScreen(navController = navController, movieViewModel = hiltViewModel())
    }

    composable(route = PlayDestination.route) {
        PlayScreen(navController)
    }

    composable(route = ProfileDestination.route) {
        ProfileScreen(
            navController = navController,
            loginViewModel = hiltViewModel()
        )
    }
}
