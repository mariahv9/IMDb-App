package com.example.imdbapp.data

import com.example.imdbapp.data.datasource.LocalDataSource
import com.example.imdbapp.data.db.RoomDB
import com.example.imdbapp.data.db.entities.MovieEntity
import com.example.imdbapp.data.network.ApiService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@ExperimentalCoroutinesApi
class LocalDataSourceTest {
    @MockK
    lateinit var roomDB: RoomDB

    @MockK
    lateinit var apiService: ApiService

    @InjectMockKs
    lateinit var localDataSource: LocalDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `LocalDataSource() should call getMovieList()`() =
        runBlocking {
            // Given
            val data = mockk<List<MovieEntity>>()

            coEvery { roomDB.movieDao().getMovie() } returns data

            // When
            localDataSource.getMovieList()

            // Then
            coVerify { roomDB.movieDao().getMovie() }
        }
}