package com.example.imdbapp.ui.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R

@Composable
fun EmailField(
    email: String,
    onTextFieldChanged: (String) -> Unit,
    outline: Color
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.dark_gray),
            backgroundColor = colorResource(id = R.color.white),
            focusedIndicatorColor = outline,
            unfocusedIndicatorColor = outline
        ),
        shape = RoundedCornerShape(15.dp)
    )
}
