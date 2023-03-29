package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.mapper.toMovieDTO
import com.example.imdbapp.data.model.MovieDTO
import com.example.imdbapp.data.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovieList(): List<MovieDTO> =
        apiService.getMovies().results.map { it.toMovieDTO() }

//    suspend fun getMovieByName(searchMovieText: String): List<MovieDTO> {
//        if (movieList.isEmpty() || searchMovieText.isEmpty()) {
//            movieList = apiService.getMovies()
//        } else if (searchMovieText.isNotEmpty()) {
//            movieList = filterMovies(searchMovieText)
//        }
//        return movieList
//    }
//
//    private fun filterMovies(searchMovieText: String): List<MovieDTO> {
//        return movieList.filter {
//            it.title!!.contains(searchMovieText, ignoreCase = true)
//        }
//    }
}
