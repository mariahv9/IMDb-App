package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface MovieImdbRepository {
    suspend fun getMovieList(): Flow<List<MovieModel>>
}
