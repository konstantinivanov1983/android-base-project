package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesCache
import com.konstantiniiv.baseproject.domain.movies.MoviesRepo
import com.orhanobut.logger.Logger
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class MoviesRepoImpl constructor(retrofit: Retrofit,
        //private val moviesCache: MoviesCache,
                                 val movieMapper: MovieMapper) : MoviesRepo {

    private val remoteDataStore: RemoteMoviesDataStore

    init {
        remoteDataStore = RemoteMoviesDataStore(retrofit = retrofit, movieMapper = movieMapper)
    }

    /*override fun getTopRatedMovies(): Flowable<List<Movie>> {
        return cloudCache.getTopRatedMovies()
                .flatMap { t: List<MovieEntity> -> Flowable.just(movieMapper.map(t)) }
    }*/

    override fun getMoviesByVotes(averageVote: Float): Flowable<List<MovieEntity>> {
        Observable.fromCallable { }
        throw UnsupportedOperationException("not implemented")
    }

    override fun getMovie(movieId: Int): Flowable<List<MovieEntity>> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getTopVotedMovies(): Observable<List<MovieEntity>> {
        Logger.d("222222")
        return remoteDataStore.getTopRatedMovies()
    }
}