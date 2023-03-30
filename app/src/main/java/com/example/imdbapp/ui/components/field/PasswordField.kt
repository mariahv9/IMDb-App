package com.example.imdbapp.ui.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R

@Composable
fun PasswordField(
    password: String,
    onTextFieldChanged: (String) -> Unit,
    onClick: () -> Unit,
    passVisibility: Boolean,
    painter: Painter,
    outline: Color
) {
    OutlinedTextField(
        value = password,
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.dark_gray),
            backgroundColor = colorResource(id = R.color.white),
            focusedIndicatorColor = outline,
            unfocusedIndicatorColor = outline
        ),
        maxLines = 1,
        singleLine = true,
        onValueChange = { onTextFieldChanged(it) },
        trailingIcon = {
            IconButton(
                onClick = { onClick() }
            ) {
                Icon(
                    painter = painter,
                    contentDescription = "Visibility"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
        ),
        visualTransformation = if (passVisibility) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}
