package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.db.MovieDao
import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesCache
import io.reactivex.Observable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 28.05.2018.
 */
class RoomMoviesCache(database: AppDatabase,
                      private val movieMapper: MovieMapper) : MoviesCache {

    private val dao: MovieDao = database.movieDao()

    override fun save(movie: MovieEntity) {
        dao.insert(movieMapper.reverseMap(movie))
    }

    override fun saveAll(movies: List<MovieEntity>) {
        dao.insert(movieMapper.reverseMap(movies))
    }

    override fun remove(movie: MovieEntity) {
        dao.delete(movieMapper.reverseMap(movie))
    }

    override fun remove(movies: List<MovieEntity>) {
        dao.delete(movieMapper.reverseMap(movies))
    }

    override fun clear() {
        dao.deleteAll()
    }

    override fun get(movieId: Int): Observable<List<MovieEntity>> {
        val movie = dao.get(moviId = movieId)
        val list = ArrayList<MovieEntity>()
        if (movie != null) list.add(movieMapper.map(movie))
        return Observable.just(list)
    }

    override fun getAll(): Observable<List<MovieEntity>> {
        return Observable.fromCallable { movieMapper.map(dao.getAll()) }
    }

    override fun isEmpty(): Observable<Boolean> {
        throw UnsupportedOperationException("not implemented")
    }
}