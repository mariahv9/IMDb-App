package com.example.imdbapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.ProfileListHelper
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun CardRecyclerProfile(
    modifier: Modifier,
    movie: ProfileListHelper
) {
    Column {
        Card(
            backgroundColor = colorResource(id = R.color.light_gray),
            modifier = modifier
                .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 8.dp)
                .height(100.dp)
        ) {
            Regular(
                modifier = modifier.padding(top = 10.dp, start = 10.dp),
                color = colorResource(id = R.color.black),
                text = stringResource(id = movie.title),
                textUnit = 12.sp
            )
        }
        Column {
            Regular(
                modifier = modifier.padding(start = 15.dp),
                color = colorResource(id = R.color.black),
                text = stringResource(id = movie.subtitle),
                textUnit = 12.sp
            )
            Regular(
                modifier = modifier.padding(start = 15.dp),
                color = colorResource(id = R.color.gray),
                maxLines = 1,
                text = stringResource(id = movie.quantity),
                textUnit = 12.sp
            )
        }
    }
}
