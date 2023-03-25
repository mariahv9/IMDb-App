package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.BottomBar
import com.example.imdbapp.viewmodel.SearchViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    val text: String by viewModel.text.observeAsState(initial = "")
    Scaffold(
        bottomBar = { BottomBar(Modifier) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.light_gray))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(bottom = 10.dp)
                    .background(colorResource(id = R.color.white))
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 10.dp)
                        .fillMaxWidth()
                        .height(65.dp),
                    value = text,
                    onValueChange = { viewModel.onTextChanged(it) },
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
        }
    }
}
