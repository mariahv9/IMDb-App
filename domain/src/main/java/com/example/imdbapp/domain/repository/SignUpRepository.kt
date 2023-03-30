package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel

interface SignUpRepository {
    suspend fun register(userModel: UserModel): Resource<Boolean>
}
