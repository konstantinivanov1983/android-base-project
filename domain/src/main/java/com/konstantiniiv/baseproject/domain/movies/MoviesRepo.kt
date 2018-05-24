package com.konstantiniiv.baseproject.domain.movies

import com.konstantiniiv.baseproject.domain.model.MovieEntity
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
interface MoviesRepo {

    fun getMoviesByVotes(averageVote : Float) : Flowable<List<MovieEntity>>
    fun getTopVotedMovies() : Observable<List<MovieEntity>>
    fun getMovie(movieId : Int) : Flowable<List<MovieEntity>>

}