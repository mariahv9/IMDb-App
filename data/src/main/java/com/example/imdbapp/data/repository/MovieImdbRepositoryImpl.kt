package com.example.imdbapp.data.repository

import com.example.imdbapp.data.datasource.RemoteDataSource
import com.example.imdbapp.data.mapper.listMovieDTOTtoMovieModel
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.repository.MovieImdbRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieImdbRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MovieImdbRepository {
    override suspend fun getMovieList(): List<MovieModel> {
        val result = remoteDataSource
            .getMovieList()
            .listMovieDTOTtoMovieModel()
        return result
    }
}
