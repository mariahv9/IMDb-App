package com.example.imdbapp.data.di

import com.example.imdbapp.data.datasource.LocalDataSource
import com.example.imdbapp.data.db.RoomDB
import com.example.imdbapp.data.repository.MovieImdbRepositoryImpl
import com.example.imdbapp.domain.repository.MovieImdbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideMovieRepository(
        localDataSource: LocalDataSource,
        roomDB: RoomDB
    ): MovieImdbRepository =
        MovieImdbRepositoryImpl(localDataSource, roomDB)
}
