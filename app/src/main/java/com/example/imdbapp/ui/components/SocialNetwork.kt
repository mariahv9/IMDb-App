package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R

@Composable
fun SocialNetwork(modifier: Modifier) {
    Row(modifier = modifier.padding(top = 10.dp)) {
        ButtonSocialNetwork(painter = painterResource(id = R.drawable.apple))
        ButtonSocialNetwork(painter = painterResource(id = R.drawable.facebook))
        ButtonSocialNetwork(painter = painterResource(id = R.drawable.google))
    }
}

@Composable
fun ButtonSocialNetwork(painter: Painter) {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(end = 15.dp, top = 15.dp, bottom = 10.dp)
            .height(60.dp)
            .width(60.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.white)
        )
    ) {
        Image(painter = painter, contentDescription = "Icono")
    }
}
