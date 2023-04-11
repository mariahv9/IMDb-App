package com.example.imdbapp.data.network

import com.example.imdbapp.common.Constants.POPULAR
import com.example.imdbapp.common.Constants.TOP_RATED
import com.example.imdbapp.data.reponse.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(TOP_RATED)
    suspend fun getMovies(): Response<MovieResponse>

    @GET(POPULAR)
    suspend fun getPopularMovies(): Response<MovieResponse>
}
