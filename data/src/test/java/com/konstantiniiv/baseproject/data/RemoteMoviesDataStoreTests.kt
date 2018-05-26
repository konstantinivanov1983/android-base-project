package com.konstantiniiv.baseproject.data

import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.data.models.MovieData
import com.konstantiniiv.baseproject.data.movies.RemoteMoviesDataStore
import com.konstantiniiv.baseproject.data.network.Api
import com.konstantiniiv.baseproject.data.network.TopRatedMoviesResponse
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 25.05.2018.
 */
@Suppress("IllegalIdentifier")
class RemoteMoviesDataStoreTests {

    private val movieMapper: MovieMapper = MovieMapper()
    private lateinit var api: Api
    private lateinit var remoteMoviesDataStore: RemoteMoviesDataStore

    @Before
    fun init() {
        api = mock(Api::class.java)
        remoteMoviesDataStore = RemoteMoviesDataStore(api = api, movieMapper = movieMapper)
    }

    @Test
    fun testWhenRequestingTopRatedMoviesFromServerReturnExpectedResult() {
        val topMovies = (1..5).map {
            MovieData(id = it,
                    runtime = 10 * it,
                    nameOriginal = "MovieTitle#$it",
                    voteAverage = 1f * it)
        }
        val result = TopRatedMoviesResponse(results = topMovies)
        result.page = 1
        Mockito.`when`(api.getTopRatedMovies("113c6620415499150cc52d8eca8d8e0b"))
                .thenReturn(Observable.just(result))

        remoteMoviesDataStore.getTopRatedMovies().test()
                .assertValue { t: List<MovieEntity> ->
                    t.size == 5 && t[4].runtime == 50 && t[3].title == "MovieTitle#4"
                }
                .assertComplete()

    }

}