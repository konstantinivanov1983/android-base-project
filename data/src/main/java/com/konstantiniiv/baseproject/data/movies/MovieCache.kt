package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.data.models.MovieData
import io.reactivex.Flowable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
interface MovieCache {

    fun getTopRatedMovies() : Flowable<List<MovieData>>

}