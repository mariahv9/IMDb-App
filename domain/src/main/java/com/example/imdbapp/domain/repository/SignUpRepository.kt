package com.example.imdbapp.domain.repository

import com.example.imdbapp.common.Resource
import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface SignUpRepository {
    suspend fun register(userModel: UserModel): Flow<Boolean>
}
