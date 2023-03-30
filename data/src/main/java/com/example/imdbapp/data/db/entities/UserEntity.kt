package com.example.imdbapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val _unique: Int = 0,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "urlPhoto")
    val urlPhoto: String,
    @ColumnInfo(name = "token")
    val token: String,
    @ColumnInfo(name = "isLogged")
    val isLogged: Boolean
)
