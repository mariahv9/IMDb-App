package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.dao.SignUpDAO
import com.example.imdbapp.data.db.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpDataSource @Inject constructor(private val signUpDAO: SignUpDAO) {

    suspend fun validateRegister(userEntity: UserEntity): Flow<Boolean> =
        try {
            when (withContext(Dispatchers.IO) { signUpDAO.getByEmail(userEntity.email) }) {
                0 -> {
                    signUpDAO.transaction(userEntity)
                    flowOf(true)
                }
                else -> {
                    flowOf(false)
                }
            }
        } catch (exception: Exception) {
            flowOf(false)
        }
}
