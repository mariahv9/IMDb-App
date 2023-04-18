package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.CardRecyclerMovie
import com.example.imdbapp.ui.components.CustomBottomBar
import com.example.imdbapp.ui.components.text.Bold
import com.example.imdbapp.viewmodel.MovieViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    movieViewModel: MovieViewModel
) {
    val moviePopularState by movieViewModel.popularMovieState.collectAsState()
    Scaffold(
        bottomBar = { CustomBottomBar(navController) }
    ) {
        Column(
            modifier = Modifier.padding(
                top = 10.dp,
                start = 15.dp,
                end = 35.dp,
                bottom = 15.dp
            )
        ) {
            Row {
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
                    text = stringResource(id = R.string.popular),
                    textUnit = 25.sp
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                if (moviePopularState.isNotEmpty()) {
                    itemsIndexed(moviePopularState) { _, movie ->
                        CardRecyclerMovie(movie = movie)
                    }
                }
            }
        }
    }
}
