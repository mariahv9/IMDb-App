package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface SignUpDataSource {
    suspend fun register(userEntity: UserEntity): Flow<Boolean>
    suspend fun validateRegister(userEntity: UserEntity): Flow<Boolean>
}
