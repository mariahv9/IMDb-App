package com.example.imdbapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.Bold

@Composable
fun PlayScreen() {
    Bold(
        modifier = Modifier,
        color = colorResource(id = R.color.black),
        text = "Play Screen",
        textUnit = 20.sp
    )
}
