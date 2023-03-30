package com.example.imdbapp.data.mapper

import com.example.imdbapp.data.db.entities.MovieEntity
import com.example.imdbapp.data.model.MovieDTO
import com.example.imdbapp.data.reponse.MovieResulResponse
import com.example.imdbapp.domain.Constants.BASE_URL_MAGE
import com.example.imdbapp.domain.model.MovieModel

fun MovieDTO.toMovieEntity(): MovieEntity {
    return MovieEntity(
        adult = this.adult ?: false,
        backdrop_path = this.backdrop_path ?: "",
        id = this.id ?: 0,
        original_language = this.original_language ?: "",
        original_title = this.original_title ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0.0,
        poster_path = this.poster_path ?: "",
        release_date = this.release_date ?: "",
        title = this.title ?: "",
        video = this.video ?: false,
        vote_average = this.vote_average ?: 0.0,
        vote_count = this.vote_count ?: 0
    )
}

fun MovieModel.toMovieEntity(): MovieEntity {
    return MovieEntity(
        adult = this.adult,
        backdrop_path = this.backdrop_path,
        id = this.id,
        original_language = this.original_language,
        original_title = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = this.poster_path,
        release_date = this.release_date,
        title = this.title,
        video = this.video,
        vote_average = this.vote_average,
        vote_count = this.vote_count
    )
}

fun MovieEntity.toMovieModel(): MovieModel {
    return MovieModel(
        adult = this.adult,
        backdrop_path = this.backdrop_path,
        id = this.id,
        original_language = this.original_language,
        original_title = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = this.poster_path,
        release_date = this.release_date,
        title = this.title,
        video = this.video,
        vote_average = this.vote_average,
        vote_count = this.vote_count
    )
}

fun MovieDTO.toMovieModel(): MovieModel {
    return MovieModel(
        adult = this.adult ?: false,
        backdrop_path = this.backdrop_path ?: "",
        id = this.id ?: 0,
        original_language = this.original_language ?: "",
        original_title = this.original_title ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0.0,
        poster_path = this.poster_path ?: "",
        release_date = this.release_date ?: "",
        title = this.title ?: "",
        video = this.video ?: false,
        vote_average = this.vote_average ?: 0.0,
        vote_count = this.vote_count ?: 0
    )
}

fun MovieResulResponse.toMovieDTO() = MovieDTO(
    adult = adult,
    id = id,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    backdrop_path = BASE_URL_MAGE.plus(backdrop_path),
    poster_path = BASE_URL_MAGE.plus(poster_path),
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)

fun List<MovieDTO>?.listMovieDTOToMovieEntity(): List<MovieEntity> {
    return this?.map { list -> list.toMovieEntity() } ?: listOf()
}

fun List<MovieModel>?.listMovieModelToMovieEntity(): List<MovieEntity> {
    return this?.map { list -> list.toMovieEntity() } ?: listOf()
}

fun List<MovieEntity>?.listMovieEntityToMovieModel(): List<MovieModel> {
    return this?.map { list -> list.toMovieModel() } ?: listOf()
}

fun List<MovieDTO>?.listMovieDTOTtoMovieModel(): List<MovieModel> {
    return this?.map { list -> list.toMovieModel() } ?: listOf()
}
