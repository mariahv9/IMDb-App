package com.example.imdbapp.domain.repository

import com.example.imdbapp.data.datasource.LocalDataSource
import com.example.imdbapp.domain.mapper.listMovieDTOTtoMovieModel
import com.example.imdbapp.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieImdbRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : MovieImdbRepository {
    override suspend fun getMovieList(): Flow<List<MovieModel>> {
        return localDataSource
            .getMovieList().map { it.listMovieDTOTtoMovieModel() }
    }

    override suspend fun getPopularMovieList(): Flow<List<MovieModel>> {
        return localDataSource
            .getPopularMovieList().map { it.listMovieDTOTtoMovieModel() }
    }
}
