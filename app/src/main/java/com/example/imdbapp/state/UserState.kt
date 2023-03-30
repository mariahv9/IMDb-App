package com.example.imdbapp.state

data class UserState(
    var id: String = "",
    var email: String = "",
    var password: String = "",
    var name: String = "",
    val urlPhoto: String = "",
    val token: String = "",
    val isLogged: Boolean = false
)