package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.entities.UserEntity
import com.example.imdbapp.domain.common.Resource

interface SignUpDataSource {
    suspend fun register(userEntity: UserEntity): Resource<Boolean>
    suspend fun validateRegister(userEntity: UserEntity): Resource<Boolean>
}
