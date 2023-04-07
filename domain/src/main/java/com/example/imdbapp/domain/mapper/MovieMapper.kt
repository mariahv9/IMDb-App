package com.example.imdbapp.domain.mapper

import com.example.imdbapp.data.db.entities.MovieEntity
import com.example.imdbapp.data.model.MovieDTO
import com.example.imdbapp.domain.model.MovieModel

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

fun List<MovieModel>?.listMovieModelToMovieEntity(): List<MovieEntity> {
    return this?.map { list -> list.toMovieEntity() } ?: listOf()
}

fun List<MovieEntity>?.listMovieEntityToMovieModel(): List<MovieModel> {
    return this?.map { list -> list.toMovieModel() } ?: listOf()
}

fun List<MovieDTO>?.listMovieDTOTtoMovieModel(): List<MovieModel> {
    return this?.map { list -> list.toMovieModel() } ?: listOf()
}
