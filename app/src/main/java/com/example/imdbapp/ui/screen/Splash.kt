package com.example.imdbapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.imdbapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(500)
        onNavigate()
    }
    Splash()
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_color))
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.imdb_logo),
            contentDescription = "Logo"
        )
    }
}
