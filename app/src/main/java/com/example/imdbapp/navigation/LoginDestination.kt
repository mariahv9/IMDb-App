package com.example.imdbapp.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.imdbapp.ui.screen.SearchScreen
import com.example.imdbapp.ui.screen.SignUpScreen

object LoginDestination : NavegationDestination {
    override val route: String = "login_route"
    override val destination: String = "login_destination"
}

object SignUpDestination : NavegationDestination {
    override val route: String = "signUp_route"
    override val destination: String = "signUp_destination"
}

object SearchDestination : NavegationDestination {
    override val route: String = "search_route"
    override val destination: String = "search_destination"
}

fun NavGraphBuilder.loginGraph(navController: NavController, onBack: () -> Unit) {
    composable(route = SignUpDestination.route) {
        SignUpScreen(
            onBack = { onBack() },
            viewModel = hiltViewModel()
        )
    }

    composable(route = SearchDestination.route) {
        SearchScreen(viewModel = hiltViewModel())
    }
}
