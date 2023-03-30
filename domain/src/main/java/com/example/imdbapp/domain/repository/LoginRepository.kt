package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel

interface LoginRepository {
    suspend fun login(email: String, password: String): Resource<UserModel>
    suspend fun isLogged(): Resource<UserModel>
}
