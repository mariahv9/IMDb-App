package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.ui.components.text.Bold
import com.example.imdbapp.viewmodel.MovieViewModel

@Composable
fun MovieSectionHome(
    title: String,
    list: List<MovieModel>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .background(colorResource(id = R.color.white))
    ) {
        Column {
            Row(Modifier.padding(top = 8.dp)) {
                Image(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.yellow_line),
                    contentDescription = "Divider"
                )
                Bold(
                    modifier = Modifier.padding(start = 3.dp, top = 2.dp),
                    color = colorResource(id = R.color.black),
                    text = title,
                    textUnit = 25.sp
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(top = 20.dp, start = 4.dp)
                    .fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                if (list.isNotEmpty()) {
                    itemsIndexed(list) { _, movie ->
                        CardRecyclerMovie(movie = movie)
                    }
                }
            }
        }
    }
}
