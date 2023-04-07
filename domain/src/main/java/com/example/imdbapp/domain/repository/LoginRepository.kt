package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(email: String, password: String): Flow<UserModel>
    suspend fun isLogged(): Flow<UserModel>
}
