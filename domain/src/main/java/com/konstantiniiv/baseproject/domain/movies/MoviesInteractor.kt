package com.konstantiniiv.baseproject.domain.movies

import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class MoviesInteractor @Inject constructor(private val moviesRepo: MoviesRepo) {

    fun getTopRatedMovies() = moviesRepo.getTopRatedMovies()

}