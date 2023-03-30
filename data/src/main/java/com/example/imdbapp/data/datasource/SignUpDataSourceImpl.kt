package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.db.dao.SignUpDAO
import com.example.imdbapp.data.db.entities.UserEntity
import com.example.imdbapp.domain.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpDataSourceImpl @Inject constructor(private val signUpDAO: SignUpDAO) :
    SignUpDataSource {

    override suspend fun register(userEntity: UserEntity): Resource<Boolean> =
        try {
            withContext(Dispatchers.IO) { signUpDAO.transaction(userEntity) }
            Resource.Success(true)
        } catch (exception: Exception) {
            Resource.Failure(exception)
        }


    override suspend fun validateRegister(userEntity: UserEntity): Resource<Boolean> =
        try {
            when (withContext(Dispatchers.IO) { signUpDAO.getByEmail(userEntity.email) }) {
                0 -> {
                    signUpDAO.transaction(userEntity)
                    Resource.Success(true)
                }
                else -> {
                    Resource.Failure(Exception())
                }
            }
        } catch (exception: Exception) {
            Resource.Failure(exception)
        }
}
