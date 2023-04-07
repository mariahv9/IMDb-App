package com.example.imdbapp.domain.usecase

import com.example.imdbapp.common.Resource
import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface GetSignUpUseCase {
    suspend fun register(userModel: UserModel): Flow<Boolean>
}
