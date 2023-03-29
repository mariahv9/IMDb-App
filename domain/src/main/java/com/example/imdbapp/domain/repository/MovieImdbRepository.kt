package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.model.MovieModel

interface MovieImdbRepository {
    suspend fun getMovieList(): List<MovieModel>
//    suspend fun getMovieList(searchMovieText: String): Resource<List<MovieModel>>
}
