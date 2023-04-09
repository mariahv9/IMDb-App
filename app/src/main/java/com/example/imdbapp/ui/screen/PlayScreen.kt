package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.imdbapp.ui.components.CustomBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayScreen(navController: NavController) {
    Scaffold(
        bottomBar = { CustomBottomBar(navController) }
    ) {
        Text(text = "Play")
    }
}
