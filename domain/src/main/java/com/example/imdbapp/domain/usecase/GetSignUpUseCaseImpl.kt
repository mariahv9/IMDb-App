package com.example.imdbapp.domain.usecase

import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.UserModel
import com.example.imdbapp.domain.repository.SignUpRepository
import javax.inject.Inject

class GetSignUpUseCaseImpl @Inject constructor(private val signUpRepository: SignUpRepository) :
    GetSignUpUseCase {
    override suspend fun register(userModel: UserModel): Resource<Boolean> {
        return signUpRepository.register(userModel)
    }
}
