package com.example.imdbapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.ButtonAccept
import com.example.imdbapp.ui.components.Medium
import com.example.imdbapp.ui.components.button.ButtonCancel
import com.example.imdbapp.ui.components.field.EmailField
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun ConfirmScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        Confirm(modifier = Modifier.align(Alignment.TopStart))
    }
}

@Composable
fun Confirm(modifier: Modifier) {
    //ArrowBack()
    Column(modifier = modifier.padding(start = 35.dp, end = 35.dp, top = 50.dp)) {
        Image(
            modifier = modifier.padding(),
            painter = painterResource(id = R.drawable.imdb_logo),
            contentDescription = "Logo"
        )
        Medium(
            modifier = modifier.padding(top = 25.dp),
            color = colorResource(id = R.color.dark_text),
            text = stringResource(id = R.string.finalizar),
            textUnit = 25.sp
        )
        Regular(
            modifier = modifier.padding(top = 10.dp),
            color = colorResource(id = R.color.dark_text),
            text = stringResource(id = R.string.connected),
            textUnit = 21.sp
        )
        Medium(
            modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
            color = colorResource(id = R.color.dark_text),
            text = stringResource(id = R.string.correo),
            textUnit = 20.sp
        )
        EmailField(
            email = "email",
            onTextFieldChanged = {},
            outline = colorResource(id = R.color.light_gray_2)
        )
        ButtonAccept { }
        ButtonCancel { }
    }
}
