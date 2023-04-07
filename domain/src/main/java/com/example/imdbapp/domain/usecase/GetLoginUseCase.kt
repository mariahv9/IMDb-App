package com.example.imdbapp.domain.usecase

import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface GetLoginUseCase {
    suspend fun login(email: String, password: String): Flow<UserModel>
    suspend fun isLogged(): Flow<UserModel>
}
