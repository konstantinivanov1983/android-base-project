package com.konstantiniiv.baseproject.data.movies

import android.graphics.Movie
import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.data.models.MovieData
import com.konstantiniiv.baseproject.data.movies.exceptions.NoMoviesException
import com.konstantiniiv.baseproject.data.network.Api
import com.konstantiniiv.baseproject.data.network.TopRatedMoviesResponse
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesDataStore
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class RemoteMoviesDataStore constructor(private val api: Api,
                                        private val movieMapper: MovieMapper) : MoviesDataStore {

    override fun getTopRatedMovies(): Observable<List<MovieEntity>> {
        return api
                .getTopRatedMovies("113c6620415499150cc52d8eca8d8e0b")
                .map { t: TopRatedMoviesResponse ->
                    t.results.map { movieData: MovieData -> movieMapper.map(movieData) } }

    }

}