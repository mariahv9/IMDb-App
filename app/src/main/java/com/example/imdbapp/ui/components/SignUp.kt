package com.example.imdbapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.LightItalic
import com.example.imdbapp.ui.components.text.MediumItalic

@Composable
fun SignUp(onNavigate: () -> Unit, modifier: Modifier) {
    Row(modifier) {
        LightItalic(
            modifier = modifier.padding(top = 20.dp),
            color = colorResource(id = R.color.dark_text),
            text = stringResource(id = R.string.cuenta_nueva),
            textUnit = 18.sp
        )
        MediumItalic(modifier = Modifier
            .clickable { onNavigate() }
            .padding(start = 5.dp, top = 20.dp),
            color = colorResource(id = R.color.dark_text),
            text = stringResource(id = R.string.registro),
            textUnit = 18.sp)
    }
}
