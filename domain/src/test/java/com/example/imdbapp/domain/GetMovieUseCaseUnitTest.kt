package com.example.imdbapp.domain

import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.repository.MovieImdbRepository
import com.example.imdbapp.domain.usecase.GetMovieUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi

class GetMovieUseCaseUnitTest {

    @MockK
    lateinit var movieImdbRepository: MovieImdbRepository

    @InjectMockKs
    lateinit var getMovieUseCase: GetMovieUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getMovieUseCase() should call getMovieList()`() =
        runBlocking {
            // Given
            val data = mockk<Flow<List<MovieModel>>>()

            coEvery { movieImdbRepository.getMovieList() } returns data

            // When
            getMovieUseCase()

            // Then
            coVerify { movieImdbRepository.getMovieList() }
        }
}