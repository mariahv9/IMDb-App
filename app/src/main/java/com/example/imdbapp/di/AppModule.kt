package com.example.imdbapp.di

import com.example.imdbapp.domain.di.DomainModule
import com.example.imdbapp.domain.repository.LoginRepository
import com.example.imdbapp.domain.usecase.GetLoginUseCase
import com.example.imdbapp.domain.usecase.GetLoginUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DomainModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providerLoginUseCase(repository: LoginRepository): GetLoginUseCase {
        return GetLoginUseCaseImpl(repository)
    }
}
