package com.example.imdbapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.usecase.GetMovieUseCase
import com.example.imdbapp.domain.usecase.GetPopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getPopularMovieUseCase: GetPopularMovieUseCase
) : ViewModel() {

    private val _movieList = MutableStateFlow((listOf<MovieModel>()))
    val movieState = _movieList.asStateFlow()

    private val _popularMovieList = MutableStateFlow((listOf<MovieModel>()))
    val popularMovieState = _popularMovieList.asStateFlow()

    init {
        getMoviesList()
        getPopularMoviesList()
    }

    private fun getMoviesList() {
        viewModelScope.launch {
            getMovieUseCase.invoke().collect { result ->
                _movieList.tryEmit(result)
            }
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

    private fun getPopularMoviesList() {
        viewModelScope.launch {
            getPopularMovieUseCase.invoke().collect {
                _popularMovieList.tryEmit(it)
            }
        }
    }
}
