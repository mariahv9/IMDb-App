package com.example.imdbapp.data.di

import android.content.Context
import com.example.imdbapp.data.db.MovieDAO
import com.example.imdbapp.data.db.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): RoomDB {
        return RoomDB.getDatabase(context)
    }

    @Singleton
    @Provides
    fun movieDao(roomDB: RoomDB): MovieDAO {
        return roomDB.movieDao()
    }
}
