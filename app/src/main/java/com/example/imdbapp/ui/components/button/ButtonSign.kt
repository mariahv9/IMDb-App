package com.example.imdbapp.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.Medium

@Composable
fun ButtonSign(
    signUpEnable: Boolean,
    onLoginSelected: () -> Unit
) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .height(65.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.dark_gray),
            disabledBackgroundColor = colorResource(id = R.color.gray),
            contentColor = colorResource(id = R.color.light_gray_text),
            disabledContentColor = colorResource(id = R.color.white)
        ),
        enabled = signUpEnable,
        shape = RoundedCornerShape(15.dp)
    ) {
        Medium(
            modifier = Modifier,
            color = colorResource(id = R.color.white),
            text = stringResource(id = R.string.signup),
            textUnit = 18.sp
        )
    }
}