package com.example.imdbapp.data.repository

import com.example.imdbapp.data.datasource.LoginDataSource
import com.example.imdbapp.data.mapper.toUserModel
import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel
import com.example.imdbapp.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginDataSource: LoginDataSource) :
    LoginRepository {
    override suspend fun login(email: String, password: String): Resource<UserModel> =
        when (val response = loginDataSource.login(email = email, password = password)) {
            is Resource.Success -> {
                Resource.Success(response.data.toUserModel())
            }
            is Resource.Failure -> {
                Resource.Failure(Exception())
            }
            else -> Resource.Failure(Exception())
        }

    override suspend fun isLogged(): Resource<UserModel> =
        when (val response = loginDataSource.isLogged()) {
            is Resource.Success -> {
                Resource.Success(response.data.toUserModel())
            }
            is Resource.Failure -> {
                Resource.Failure(Exception())
            }
            else -> Resource.Failure(Exception())
        }
}
