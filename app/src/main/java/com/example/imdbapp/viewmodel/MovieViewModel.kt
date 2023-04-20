package com.example.imdbapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.domain.usecase.GetMovieUseCase
import com.example.imdbapp.domain.usecase.GetPopularMovieUseCase
import com.example.imdbapp.mapper.toState
import com.example.imdbapp.state.MovieState
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

    private val _movieList = MutableStateFlow((listOf<MovieState>()))
    val movieState = _movieList.asStateFlow()

    private val _popularMovieList = MutableStateFlow((listOf<MovieState>()))
    val popularMovieState = _popularMovieList.asStateFlow()

    var popularMovies by mutableStateOf(listOf<MovieState>())
    var topMovie by mutableStateOf(MovieState())

    init {
        getMoviesList()
        getPopularMoviesList()
    }

    private fun getMoviesList() {
        viewModelScope.launch {
            getMovieUseCase.invoke().collect { result ->
                _movieList.tryEmit(result.map { it.toState() })
            }
        }
    }

    fun searchMovie(searchMovieText: String): List<MovieState> =
        when (searchMovieText.isNotEmpty()) {
            true -> {
                val moviesSearched = mutableListOf<MovieState>()
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
            getPopularMovieUseCase.invoke().collect { movies ->
                _popularMovieList.tryEmit(movies.map { it.toState() })
                popularMovies = _popularMovieList.value.sortedBy { it.vote_average }.asReversed()
                topMovie = popularMovies.first()
                popularMovies = popularMovies.filter { it.vote_average != topMovie.vote_average }
            }
        }
    }
}
