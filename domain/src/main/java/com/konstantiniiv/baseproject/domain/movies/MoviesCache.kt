package com.konstantiniiv.baseproject.domain.movies

import com.konstantiniiv.baseproject.domain.model.MovieEntity
import io.reactivex.Flowable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 24.05.2018.
 */
interface MoviesCache{

    fun clear()
    fun save(movie: MovieEntity)
    fun remove(movie: MovieEntity)
    fun saveAll(movies: List<MovieEntity>)
    fun getAll() : Flowable<List<MovieEntity>>
    fun get(movieId: Int) : Flowable<MovieEntity>
    fun isEmpty() : Flowable<Boolean>
}