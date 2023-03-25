package com.example.imdbapp.ui.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.dark_gray),
            backgroundColor = colorResource(id = R.color.white),
            focusedIndicatorColor = colorResource(id = R.color.white),
            unfocusedIndicatorColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(15.dp)
    )
}
