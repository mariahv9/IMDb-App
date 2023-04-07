package com.example.imdbapp.domain.repository

import com.example.imdbapp.data.datasource.SignUpDataSource
import com.example.imdbapp.domain.mapper.toUserEntity
import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val signUpDataSource: SignUpDataSource) :
    SignUpRepository {
    override suspend fun register(userModel: UserModel): Flow<Boolean> {
        return signUpDataSource.validateRegister(userModel.toUserEntity())
    }
}