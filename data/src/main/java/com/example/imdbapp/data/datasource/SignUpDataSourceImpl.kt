package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.dao.SignUpDAO
import com.example.imdbapp.data.db.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpDataSourceImpl @Inject constructor(private val signUpDAO: SignUpDAO) :
    SignUpDataSource {

    override suspend fun register(userEntity: UserEntity): Flow<Boolean> =
        try {
            withContext(Dispatchers.IO) { signUpDAO.transaction(userEntity) }
            flowOf(true)
        } catch (exception: Exception) {
            flowOf(false)
        }


    override suspend fun validateRegister(userEntity: UserEntity): Flow<Boolean> =
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
