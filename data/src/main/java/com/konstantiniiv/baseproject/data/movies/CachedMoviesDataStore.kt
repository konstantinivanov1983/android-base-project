package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.models.MovieData
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class CachedMoviesDataStore @Inject constructor(val database : AppDatabase) : MovieCache {

    override fun getTopRatedMovies(): Flowable<List<MovieData>> {
        throw UnsupportedOperationException("not implemented")
    }
}