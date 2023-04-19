package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.imdbapp.R
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.ui.components.CustomBottomBar
import com.example.imdbapp.ui.components.MovieSectionHome
import com.example.imdbapp.ui.components.text.Bold
import com.example.imdbapp.ui.components.text.Regular
import com.example.imdbapp.viewmodel.MovieViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    movieViewModel: MovieViewModel
) {
    Scaffold(
        bottomBar = { CustomBottomBar(navController) }
    ) {
        val moviePopularState by movieViewModel.popularMovieState.collectAsState()
        //val topMovie = topRatedMovie(moviePopularState)
        Box {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    Modifier
                        .height(400.dp)
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.light_gray))
                ) {
                    ConstraintLayout(
                        Modifier
                            .height(360.dp)
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white))
                    ) {
                        val (title, description, play, imagePoster, frontImage) = createRefs()
                        Box(Modifier.constrainAs(frontImage) {}
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(250.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop,
                                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500/kuf6dutpsT0vSVehic3EZIqkOBt.jpg"),
                                contentDescription = "Movie image"
                            )
                        }
                        Image(
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .constrainAs(play) {
                                    centerTo(frontImage)
                                },
                            painter = painterResource(id = R.drawable.icon_play_home),
                            contentDescription = "Play icon"
                        )
                        Bold(
                            modifier = Modifier
                                .padding(start = 15.dp, top = 5.dp)
                                .constrainAs(title) {
                                    start.linkTo(imagePoster.end)
                                    top.linkTo(frontImage.bottom)
                                },
                            color = colorResource(id = R.color.black),
                            text = "Puss in Boots",
                            textUnit = 20.sp
                        )
                        Regular(
                            modifier = Modifier
                                .padding(start = 15.dp, top = 5.dp)
                                .constrainAs(description) {
                                    start.linkTo(imagePoster.end)
                                    top.linkTo(title.bottom)
                                },
                            color = colorResource(id = R.color.black),
                            text = "Trailer Oficial",
                            textUnit = 20.sp
                        )
                        Image(
                            modifier = Modifier
                                .padding(top = 15.dp, start = 20.dp)
                                .constrainAs(imagePoster) {
                                    top.linkTo(play.top)
                                },
                            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500/kuf6dutpsT0vSVehic3EZIqkOBt.jpg"),
                            contentDescription = "Poster image"
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .background(colorResource(id = R.color.light_gray))
                ) {
                    MovieSectionHome(
                        title = stringResource(id = R.string.popular),
                        list = bestSelections(moviePopularState)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .background(colorResource(id = R.color.light_gray))
                ) {
                    MovieSectionHome(
                        title = stringResource(id = R.string.favoritos),
                        list = topRatedMovie(bestSelections(moviePopularState))
                    )
                }
                Spacer(modifier = Modifier.padding(top = 30.dp))
            }
        }
    }
}

fun topRatedMovie(list: List<MovieModel>): List<MovieModel> =
    list.sortedBy { it.vote_average }.asReversed()

fun bestSelections(list: List<MovieModel>): List<MovieModel> =
    list.filter { it.vote_average != topRatedMovie(list)[0].vote_average }
