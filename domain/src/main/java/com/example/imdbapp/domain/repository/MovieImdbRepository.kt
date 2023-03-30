package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface MovieImdbRepository {
    suspend fun getMovieList(): Flow<List<MovieModel>>
    suspend fun getUserData(userEmail: String): Resource<UserModel>
    suspend fun setUserData(
        id: String,
        email: String,
        password: String,
        name: String,
        urlPhoto: String,
        token: String
    )
}
