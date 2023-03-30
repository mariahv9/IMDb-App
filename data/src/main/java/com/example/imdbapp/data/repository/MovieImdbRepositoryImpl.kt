package com.example.imdbapp.data.repository

import com.example.imdbapp.data.datasource.LocalDataSource
import com.example.imdbapp.data.db.RoomDB
import com.example.imdbapp.data.mapper.listMovieDTOTtoMovieModel
import com.example.imdbapp.domain.common.Resource
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.model.UserModel
import com.example.imdbapp.domain.repository.MovieImdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieImdbRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val roomDB: RoomDB
) : MovieImdbRepository {
    override suspend fun getMovieList(): Flow<List<MovieModel>> {
        return localDataSource
            .getMovieList().map { it.listMovieDTOTtoMovieModel() }
    }

    override suspend fun getUserData(userEmail: String): Resource<UserModel> {
        TODO("Not yet implemented")
    }

    override suspend fun setUserData(
        id: String,
        email: String,
        password: String,
        name: String,
        urlPhoto: String,
        token: String
    ) {
        roomDB.loginDao()
    }
}
