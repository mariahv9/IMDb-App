package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.dao.LoginDAO
import com.example.imdbapp.data.db.entities.UserEntity
import com.example.imdbapp.domain.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginDatasourceImpl @Inject constructor(private val loginDAO: LoginDAO) :
    LoginDataSource {
    override suspend fun login(email: String, password: String): Resource<UserEntity> =
        try {
            val response = withContext(Dispatchers.IO) {
                loginDAO.getByEmailAndPassword(
                    email = email,
                    password = password
                )
            }
            when {
                response != null ->
                    Resource.Success(response)
                else -> Resource.Failure(Exception())
            }
        } catch (exception: Exception) {
            Resource.Failure(exception)
        }


    override suspend fun isLogged(): Resource<UserEntity> =
        try {
            val response = withContext(Dispatchers.IO) { loginDAO.getUsers() }
            when {
                response != null -> {
                    when {
                        response.isLogged -> {
                            Resource.Success(response)
                        }
                        else -> Resource.Failure(Exception())
                    }
                }
                else -> Resource.Failure(Exception())
            }
        } catch (exception: Exception) {
            Resource.Failure(exception)
        }
}