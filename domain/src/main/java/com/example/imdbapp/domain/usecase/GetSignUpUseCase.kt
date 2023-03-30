package com.example.imdbapp.domain.usecase

import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel

interface GetSignUpUseCase {
    suspend fun register(userModel: UserModel): Resource<Boolean>
}
