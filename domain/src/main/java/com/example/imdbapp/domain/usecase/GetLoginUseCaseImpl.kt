package com.example.imdbapp.domain.usecase

import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel
import com.example.imdbapp.domain.repository.LoginRepository
import javax.inject.Inject

class GetLoginUseCaseImpl @Inject constructor(private val loginRepository: LoginRepository) :
    GetLoginUseCase {
    override suspend fun login(email: String, password: String): Resource<UserModel> {
        return loginRepository.login(email, password)
    }

    override suspend fun isLogged(): Resource<UserModel> {
        return loginRepository.isLogged()
    }
}