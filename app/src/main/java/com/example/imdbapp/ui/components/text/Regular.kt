package com.example.imdbapp.ui.components.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.imdbapp.R

@Composable
fun Regular(
    modifier: Modifier,
    color: Color,
    text: String,
    textUnit: TextUnit,
    maxLines: Int = 3
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        maxLines = maxLines,
        fontStyle = FontStyle(R.font.roboto),
        fontWeight = FontWeight.Normal,
        fontSize = textUnit
    )
}
