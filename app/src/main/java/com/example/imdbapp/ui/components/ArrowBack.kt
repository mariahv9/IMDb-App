package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R

@Composable
fun ArrowBack(onBack: () -> Unit) {
    Image(
        modifier = Modifier
            .padding(20.dp)
            .clickable { onBack() },
        painter = painterResource(id = R.drawable.icon_arrow_back),
        contentDescription = "",
    )
}
