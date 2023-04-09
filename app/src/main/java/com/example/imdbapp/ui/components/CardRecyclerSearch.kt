package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.imdbapp.R
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.common.toYear
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun CardRecyclerSearch(
    movie: MovieModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, start = 10.dp, end = 15.dp)) {
            Image(
                modifier = Modifier.size(115.dp),
                painter = rememberAsyncImagePainter(movie.poster_path),
                contentDescription = "Card image"
            )
            Column() {
                Regular(
                    modifier = Modifier.padding(top = 10.dp),
                    color = colorResource(id = R.color.black),
                    text = movie.title,
                    textUnit = 18.sp
                )
                Regular(
                    modifier = Modifier.padding(top = 10.dp),
                    color = colorResource(id = R.color.gray),
                    text = movie.release_date.toYear(),
                    textUnit = 18.sp
                )
                Regular(
                    modifier = Modifier.padding(top = 20.dp),
                    color = colorResource(id = R.color.gray),
                    maxLines = 1,
                    text = movie.overview,
                    textUnit = 16.sp
                )
            }
        }
    }
}
