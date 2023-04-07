package com.example.imdbapp.domain.repository

import com.example.imdbapp.data.datasource.LoginDatasource
import com.example.imdbapp.domain.mapper.toUserModel
import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDatasource
) : LoginRepository {
    override suspend fun login(email: String, password: String): Flow<UserModel> =
        loginDataSource.login(email, password).map {
            it.toUserModel()
        }

    override suspend fun isLogged(): Flow<UserModel> {
        val response = loginDataSource.isLogged()
        response.collect {
            when {
                it.isLogged -> flowOf(response)
                else -> emptyFlow()
            }
        }
        return response.map {
            it.toUserModel()
        }
    }
}
