package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.entities.UserEntity
import com.example.imdbapp.domain.common.Resource

interface LoginDataSource {
    suspend fun login(email: String, password: String): Resource<UserEntity>
    suspend fun isLogged(): Resource<UserEntity>
}
