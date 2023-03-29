package com.example.imdbapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDTO(
    @field:Json(name = "adult")
    val adult: Boolean? = false,
    @field:Json(name = "backdrop_path")
    val backdrop_path: String? = "",
    @field:Json(name = "id")
    val id: Int? = 0,
    @field:Json(name = "original_language")
    val original_language: String? = "",
    @field:Json(name = "original_title")
    val original_title: String? = "",
    @field:Json(name = "overview")
    val overview: String? = "",
    @field:Json(name = "popularity")
    val popularity: Int? = 0,
    @field:Json(name = "poster_path")
    val poster_path: String? = "",
    @field:Json(name = "release_date")
    val release_date: String? = "",
    @field:Json(name = "title")
    val title: String? = "",
    @field:Json(name = "video")
    val video: Boolean? = false,
    @field:Json(name = "vote_average")
    val vote_average: Int? = 0,
    @field:Json(name = "vote_count")
    val vote_count: Int? = 0
)
