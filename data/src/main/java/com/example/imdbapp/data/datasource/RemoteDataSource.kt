package com.example.imdbapp.data.datasource

import com.example.imdbapp.data.mapper.toMovieDTO
import com.example.imdbapp.data.model.MovieDTO
import com.example.imdbapp.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovieList(): Flow<List<MovieDTO>> =
        try {
            val response = apiService.getMovies()
            when {
                response.isSuccessful -> flowOf(checkNotNull(response.body()?.results).map { it.toMovieDTO() })
                else -> flowOf(emptyList())
            }
        } catch (ex: Exception) {
            flowOf(emptyList())
        }

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
