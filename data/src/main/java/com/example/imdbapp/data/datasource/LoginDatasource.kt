package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.dao.LoginDAO
import com.example.imdbapp.data.db.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginDatasource @Inject constructor(private val loginDAO: LoginDAO) {
    suspend fun login(email: String, password: String): Flow<UserEntity> =
        try {
            flowOf(checkNotNull(withContext(Dispatchers.IO) {
                loginDAO.getByEmailAndPassword(email, password)
            }))
        } catch (exception: Exception) {
            flow {
                exception.message
            }
        }


    suspend fun isLogged(): Flow<UserEntity> =
        try {
            flowOf(checkNotNull(withContext(Dispatchers.IO) {
                loginDAO.getUsers()
            }))
        } catch (exception: Exception) {
            flow {
                exception.message
            }
        }
}
