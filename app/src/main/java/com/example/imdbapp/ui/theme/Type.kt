package com.example.imdbapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R

val fonts = FontFamily(
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto, weight = FontWeight.Normal),
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_thin, weight = FontWeight.Thin),
)

val Typography = Typography(
    subtitle1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
)