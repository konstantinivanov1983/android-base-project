package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesCache
import io.reactivex.Observable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 28.05.2018.
 */
class MemoryMoviesCache : MoviesCache {

    private val movies: LinkedHashMap<Int, MovieEntity> = LinkedHashMap()


    override fun clear() = movies.clear()

    override fun save(movie: MovieEntity) {
        movies[movie.id] = movie
    }

    override fun remove(movie: MovieEntity) {
        movies.remove(movie.id)
    }

    override fun saveAll(movies: List<MovieEntity>) {
        movies.forEach { movie -> this.movies[movie.id] = movie }
    }

    override fun getAll(): Observable<List<MovieEntity>> {
        return Observable.just(movies.values.toList())
    }

    //Return empty list, if entity is not present
    override fun get(movieId: Int): Observable<List<MovieEntity>> {
        val list = ArrayList<MovieEntity>()
        val movie = movies[movieId]
        if (movie != null) list.add(movie)
        return Observable.just(list)
    }

    override fun isEmpty(): Observable<Boolean> {
        return Observable.fromCallable { movies.isEmpty() }
    }

    override fun remove(movies: List<MovieEntity>) {
        throw UnsupportedOperationException("not implemented")
    }
}