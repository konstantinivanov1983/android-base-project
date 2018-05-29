package com.konstantiniiv.baseproject.domain.movies

import com.konstantiniiv.baseproject.domain.model.MovieEntity
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 24.05.2018.
 */
interface MoviesCache{

    fun clear()
    fun save(movie: MovieEntity)
    fun remove(movie: MovieEntity)
    fun remove(movies: List<MovieEntity>)
    fun saveAll(movies: List<MovieEntity>)
    fun getAll() : Observable<List<MovieEntity>>
    fun get(movieId: Int) : Observable<List<MovieEntity>>
    fun isEmpty() : Observable<Boolean>
}