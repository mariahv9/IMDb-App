package com.example.imdbapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.imdbapp.data.db.dao.LoginDAO
import com.example.imdbapp.data.db.dao.MovieDAO
import com.example.imdbapp.data.db.dao.SignUpDAO
import com.example.imdbapp.data.db.entities.MovieEntity
import com.example.imdbapp.data.db.entities.UserEntity

@Database(entities = [MovieEntity::class, UserEntity::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun movieDao(): MovieDAO
    abstract fun loginDao(): LoginDAO

    abstract fun signUpDao(): SignUpDAO


    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(
            context: Context
        ): RoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "room_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }
    }
}
