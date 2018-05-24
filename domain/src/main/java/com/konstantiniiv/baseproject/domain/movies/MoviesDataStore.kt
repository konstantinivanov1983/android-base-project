package com.konstantiniiv.baseproject.domain.movies

import com.konstantiniiv.baseproject.domain.model.MovieEntity
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 24.05.2018.
 */
interface MoviesDataStore {

    fun getTopRatedMovies() : Single<List<MovieEntity>>

}