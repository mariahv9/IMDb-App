package com.example.imdbapp.data.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movie")
    suspend fun getMovie(): List<MovieEntity>
}
