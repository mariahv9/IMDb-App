package com.example.imdbapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.imdbapp.R
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.ui.components.text.Regular

@Composable
fun CardRecyclerMovie(
    movie: MovieModel
) {
    Card(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(160.dp)
            .height(270.dp)
            .shadow(10.dp, RectangleShape, ambientColor = colorResource(id = R.color.dark_gray))
    ) {
        Column(
            modifier = Modifier.padding(
                top = 15.dp,
                bottom = 15.dp,
                start = 10.dp,
                end = 10.dp
            )
        ) {
            Image(
                modifier = Modifier.size(160.dp),
                painter = rememberAsyncImagePainter(movie.poster_path),
                contentDescription = "Card image"
            )
            Row(Modifier.padding(top = 5.dp)) {
                Image(
                    modifier = Modifier
                        .size(15.dp),
                    painter = painterResource(id = R.drawable.icon_star),
                    contentDescription = "star"
                )
                Regular(
                    modifier = Modifier.padding(start = 3.dp),
                    color = colorResource(id = R.color.dark_gray),
                    text = movie.vote_average.toString(),
                    textUnit = 15.sp
                )
            }
            Regular(
                modifier = Modifier.padding(top = 10.dp),
                color = colorResource(id = R.color.black),
                text = movie.title,
                textUnit = 15.sp
            )
        }
    }
}