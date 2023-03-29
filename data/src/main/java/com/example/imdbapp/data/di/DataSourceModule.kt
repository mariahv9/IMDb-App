package com.example.imdbapp.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
//    @Binds
//    abstract fun bindRemoteConfigDataSource(remoteConfigDataSourceImpl: RemoteConfigDataSourceImpl): RemoteConfigDataSource
}
