package com.example.imdbapp.data.network

import com.example.imdbapp.data.model.MovieDTO
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated/")
    suspend fun getMovies(): List<MovieDTO>
}
