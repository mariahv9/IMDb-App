package com.example.imdbapp.viewModel

import com.example.imdbapp.domain.model.MovieModel
import com.example.imdbapp.domain.usecase.GetMovieUseCase
import com.example.imdbapp.domain.usecase.GetPopularMovieUseCase
import com.example.imdbapp.viewmodel.MovieViewModel
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieViewModelTest {
    lateinit var getMovieUseCase: GetMovieUseCase

    lateinit var getPopularMovieUseCase: GetPopularMovieUseCase

    lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        getMovieUseCase = mockk()
        getPopularMovieUseCase = mockk()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getMovieViewModelIsSuccess() =
        runBlocking {
            // Given
            val data = listOf(
                MovieModel(
                    adult = false,
                    backdrop_path = "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                    id = 238,
                    original_language = "en",
                    original_title = "The Godfather",
                    overview = "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
                    popularity = 111.205,
                    poster_path = "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                    release_date = "1972-03-14",
                    title = "The Godfather",
                    video = false,
                    vote_average = 8.7,
                    vote_count = 17756
                ),
                MovieModel(
                    adult = false,
                    backdrop_path = "/iNh3BivHyg5sQRPP1KOkzguEX0H.jpg",
                    id = 278,
                    original_language = "en",
                    original_title = "The Shawshank Redemption",
                    overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                    popularity = 94.573,
                    poster_path = "/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
                    release_date = "1994-09-23",
                    title = "The Shawshank Redemption",
                    video = false,
                    vote_average = 8.7,
                    vote_count = 23613
                )
            )

            coEvery { getMovieUseCase.invoke() } returns flowOf(data)
            coEvery { getPopularMovieUseCase.invoke() } returns flowOf(data)

            //When
            movieViewModel = MovieViewModel(getMovieUseCase, getPopularMovieUseCase)

            //Verify
            coVerifySequence {
                getMovieUseCase.invoke()
                getPopularMovieUseCase.invoke()
            }
        }
}
