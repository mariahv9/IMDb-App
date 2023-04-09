package com.example.imdbapp.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.imdbapp.ui.screen.LoginScreen
import com.example.imdbapp.ui.screen.SplashScreen

object SplashDestination : NavegationDestination {
    override val route: String = "splash_route"
    override val destination: String = "splash_destination"
}

fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(SplashDestination.route) {
        SplashScreen(onNavigate = {
            navController.popBackStack()
            navController.navigate(LoginDestination.route)
        })
    }

    composable(LoginDestination.route) {
        LoginScreen(
            viewModel = hiltViewModel(),
            onNavigateSignUp = {
                navController.navigate(SignUpDestination.route)
            }, onNavigateHome = {
                navController.popBackStack()
                navController.navigate(HomeDestination.route)
            })
    }
}
