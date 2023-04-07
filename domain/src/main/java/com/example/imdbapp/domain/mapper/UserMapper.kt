package com.example.imdbapp.domain.mapper

import com.example.imdbapp.data.db.entities.UserEntity
import com.example.imdbapp.domain.model.UserModel

fun UserEntity.toUserModel() = UserModel(
    id = id,
    email = email,
    password = password,
    name = name,
    urlPhoto = urlPhoto,
    token = token,
    isLogged = isLogged
)

fun UserModel.toUserEntity() = UserEntity(
    id = id,
    email = email,
    password = password,
    name = name,
    urlPhoto = urlPhoto,
    token = token,
    isLogged = isLogged
)
