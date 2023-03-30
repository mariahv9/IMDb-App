package com.example.imdbapp.domain.model

data class UserModel(
    val id: String,
    val email: String,
    val password: String,
    val name: String,
    val urlPhoto: String,
    val token: String,
    val isLogged: Boolean
)
