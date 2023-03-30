package com.example.imdbapp.data.di

import android.content.Context
import com.example.imdbapp.data.datasource.LoginDataSource
import com.example.imdbapp.data.datasource.LoginDatasourceImpl
import com.example.imdbapp.data.datasource.SignUpDataSource
import com.example.imdbapp.data.datasource.SignUpDataSourceImpl
import com.example.imdbapp.data.db.RoomDB
import com.example.imdbapp.data.db.dao.LoginDAO
import com.example.imdbapp.data.db.dao.MovieDAO
import com.example.imdbapp.data.db.dao.SignUpDAO
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

    @Singleton
    @Provides
    fun loginDao(roomDB: RoomDB): LoginDAO {
        return roomDB.loginDao()
    }

    @Singleton
    @Provides
    fun signUpDao(roomDB: RoomDB): SignUpDAO {
        return roomDB.signUpDao()
    }

    @Singleton
    @Provides
    fun providerRegisterDataSource(signUpDAO: SignUpDAO): SignUpDataSource =
        SignUpDataSourceImpl(signUpDAO)

    @Singleton
    @Provides
    fun providerLoginDataSource(loginDAO: LoginDAO): LoginDataSource =
        LoginDatasourceImpl(loginDAO)
}
