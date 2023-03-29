package com.example.imdbapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.usecase.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    private val _movieList = MutableStateFlow((listOf<MovieModel>()))

    init {
        getMoviesList()
    }

    private fun getMoviesList() {
        viewModelScope.launch {
            val result = getMovieUseCase()
            _movieList.update { result }
        }
    }

    fun searchMovie(searchMovieText: String): List<MovieModel> =
        when (searchMovieText.isNotEmpty()) {
            true -> {
                val moviesSearched = mutableListOf<MovieModel>()
                _movieList.value.forEach { movie ->
                    if (movie.title.lowercase().contains(searchMovieText.lowercase())) {
                        moviesSearched.add(movie)
                    }
                }
                moviesSearched
            }
            else -> _movieList.value
        }
}
