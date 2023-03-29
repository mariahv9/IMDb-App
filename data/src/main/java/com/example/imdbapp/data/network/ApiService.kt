package com.example.imdbapp.data.network

import com.example.imdbapp.data.reponse.MovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated/")
    suspend fun getMovies(): MovieResponse
}
