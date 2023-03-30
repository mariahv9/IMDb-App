package com.example.imdbapp.data.repository

import com.example.imdbapp.data.datasource.SignUpDataSource
import com.example.imdbapp.data.mapper.toUserEntity
import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel
import com.example.imdbapp.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val signUpDataSource: SignUpDataSource) :
    SignUpRepository {
    override suspend fun register(userModel: UserModel): Resource<Boolean> {
        return signUpDataSource.validateRegister(userModel.toUserEntity())
    }
}
