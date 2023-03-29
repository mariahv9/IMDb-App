package com.example.imdbapp.ui.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R
import com.example.imdbapp.viewmodel.SearchViewModel

@Composable
fun SearchTextField(state: MutableState<String>) {
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
            .height(65.dp),
        value = state.value,
        onValueChange = { state.value = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = colorResource(id = R.color.light_gray_2),
                contentDescription = "Search icon"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.gray),
            backgroundColor = colorResource(id = R.color.light_gray),
            focusedIndicatorColor = colorResource(id = R.color.white),
            unfocusedIndicatorColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(15.dp),
    )
}
