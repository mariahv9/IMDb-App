package com.example.imdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.imdbapp.data.db.entities.UserEntity

@Dao
interface LoginDAO {
    @Query("SELECT * FROM user")
    suspend fun getUsers(): UserEntity?

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun getByEmailAndPassword(email: String, password: String): UserEntity?

    @Query("SELECT * FROM user WHERE email = :email")
    fun getByEmail(email: String): UserEntity?
}
