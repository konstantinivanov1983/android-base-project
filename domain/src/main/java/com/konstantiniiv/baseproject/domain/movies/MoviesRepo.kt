package com.konstantiniiv.baseproject.domain.movies

import com.konstantiniiv.baseproject.domain.model.MovieEntity
import io.reactivex.Flowable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
interface MoviesRepo {

    fun getMoviesByVotes(averageVote : Float) : Flowable<List<MovieEntity>>
    fun getMovie(movieId : Int) : Flowable<List<MovieEntity>>

}