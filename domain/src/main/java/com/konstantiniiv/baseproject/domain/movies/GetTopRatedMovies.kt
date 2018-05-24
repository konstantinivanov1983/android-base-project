package com.konstantiniiv.baseproject.domain.movies

import com.konstantiniiv.baseproject.domain.global.Transformer
import com.konstantiniiv.baseproject.domain.global.UseCase
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import io.reactivex.Observable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 24.05.2018.
 */
class GetTopRatedMovies(transformer: Transformer<List<MovieEntity>>,
                        private val moviesRepo: MoviesRepo): UseCase<List<MovieEntity>>(transformer){

    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        return moviesRepo.getTopVotedMovies()
    }

}