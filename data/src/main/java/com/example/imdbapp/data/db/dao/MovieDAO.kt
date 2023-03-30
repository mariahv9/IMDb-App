package com.example.imdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.imdbapp.data.db.entities.MovieEntity

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movie")
    suspend fun getMovie(): List<MovieEntity>
}
