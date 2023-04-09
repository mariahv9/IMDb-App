package com.example.imdbapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.imdbapp.R
import com.example.imdbapp.viewmodel.LoginViewModel

@Composable
fun CardProfileHeader(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(bottom = 10.dp)
            .background(colorResource(id = R.color.white))
    ) {
        CardProfile(Modifier.align(Alignment.TopStart), loginViewModel)
    }
}

@Composable
fun CardProfile(modifier: Modifier, loginViewModel: LoginViewModel) {
    HeaderProfile(modifier, loginViewModel)
    LineDivider(
        modifier.padding(top = 60.dp, start = 35.dp, end = 35.dp),
        colorResource(id = R.color.black_op)
    )
    //add recyclerview
}