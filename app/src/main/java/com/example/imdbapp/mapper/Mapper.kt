package com.example.imdbapp.mapper

import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.model.UserModel
import com.example.imdbapp.state.MovieState
import com.example.imdbapp.state.UserState

fun UserState.toUserModel() = UserModel(
    id = id,
    email = email,
    password = password,
    name = name,
    urlPhoto = urlPhoto,
    token = token,
    isLogged = true
)

fun UserState.toUserState() = UserState(
    id = id,
    email = email,
    password = password,
    name = name,
    urlPhoto = urlPhoto,
    token = token,
    isLogged = true
)

fun MovieModel.toState() = MovieState(
    adult,
    backdrop_path,
    id,
    original_language,
    original_title,
    overview,
    popularity,
    poster_path,
    release_date,
    title,
    video,
    vote_average,
    vote_count
)
