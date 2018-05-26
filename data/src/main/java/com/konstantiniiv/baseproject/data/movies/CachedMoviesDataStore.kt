package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.models.MovieData
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesDataStore
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class CachedMoviesDataStore @Inject constructor(val cache: MovieCache) : MoviesDataStore {

    override fun getTopRatedMovies(): Observable<List<MovieEntity>> {
        throw UnsupportedOperationException("not implemented")
    }
}