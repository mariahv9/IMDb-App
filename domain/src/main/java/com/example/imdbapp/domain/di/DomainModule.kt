package com.example.imdbapp.domain.di

import com.example.imdbapp.data.datasource.LocalDataSource
import com.example.imdbapp.data.datasource.LoginDatasource
import com.example.imdbapp.data.datasource.SignUpDataSource
import com.example.imdbapp.domain.repository.LoginRepository
import com.example.imdbapp.domain.repository.LoginRepositoryImpl
import com.example.imdbapp.domain.repository.MovieImdbRepository
import com.example.imdbapp.domain.repository.MovieImdbRepositoryImpl
import com.example.imdbapp.domain.repository.SignUpRepository
import com.example.imdbapp.domain.repository.SignUpRepositoryImpl
import com.example.imdbapp.domain.usecase.GetSignUpUseCase
import com.example.imdbapp.domain.usecase.GetSignUpUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providerLoginRepository(loginDataSource: LoginDatasource): LoginRepository {
        return LoginRepositoryImpl(loginDataSource)
    }

    @Provides
    fun provideMovieRepository(localDataSource: LocalDataSource): MovieImdbRepository =
        MovieImdbRepositoryImpl(localDataSource)

    @Provides
    fun providesSignUpUseCase(signUpRepository: SignUpRepository): GetSignUpUseCase =
        GetSignUpUseCaseImpl(signUpRepository)

    @Provides
    fun providesSignUpRepository(signUpDataSource: SignUpDataSource): SignUpRepository =
        SignUpRepositoryImpl(signUpDataSource)
}
