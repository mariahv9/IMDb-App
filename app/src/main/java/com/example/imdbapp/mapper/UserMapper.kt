package com.example.imdbapp.mapper

import com.example.imdbapp.domain.model.UserModel
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
