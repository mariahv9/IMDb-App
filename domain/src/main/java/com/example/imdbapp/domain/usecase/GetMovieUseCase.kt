package com.example.imdbapp.domain.usecase

import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.repository.MovieImdbRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMovieUseCase @Inject constructor(private val movieRepository: MovieImdbRepository) {
    suspend operator fun invoke(): List<MovieModel> =
        movieRepository.getMovieList()
}
