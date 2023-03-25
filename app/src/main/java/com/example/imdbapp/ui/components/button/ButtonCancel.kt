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
fun ButtonCancel(onAcceptSelected: () -> Unit) {
    Button(
        onClick = { onAcceptSelected() },
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .height(65.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.dark_gray),
            disabledBackgroundColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Medium(
            modifier = Modifier,
            color = colorResource(id = R.color.dark_gray),
            text = stringResource(id = R.string.cancelar),
            textUnit = 18.sp
        )
    }
}
