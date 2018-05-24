package com.konstantiniiv.baseproject.data.movies

import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.data.movies.exceptions.NoMoviesException
import com.konstantiniiv.baseproject.data.network.Api
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesDataStore
import com.orhanobut.logger.Logger
import io.reactivex.*
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class RemoteMoviesDataStore constructor(private val retrofit: Retrofit,
                                        private val movieMapper: MovieMapper) : MoviesDataStore {

    /*override fun getTopRatedMovies(): Flowable<List<MovieEntity>> {
        return retrofit.create(Api::class.java)
                .getTopRatedMovies("113c6620415499150cc52d8eca8d8e0b")
                .subscribeOn(Schedulers.io())
                .flatMap { t: List<TopRatedMoviesResponse> -> Flowable.fromIterable(t) }
                .map { t: TopRatedMoviesResponse -> t.results }
    }*/

    override fun getTopRatedMovies(): Observable<List<MovieEntity>> {
        Logger.d("444444 ")
        return Observable.create { e: ObservableEmitter<List<MovieEntity>> ->
            try {
                Logger.d("5555 ")

                val call = retrofit.create(Api::class.java)
                        .getTopRatedMovies("113c6620415499150cc52d8eca8d8e0b")
                val response = call.execute()
                if (response.isSuccessful) {
                    val movies = response.body()?.results
                    if (movies != null) {
                        e.onNext(movieMapper.map(movies))
                        e.onComplete()
                    } else {
                        e.onError(NoMoviesException())
                    }
                } else {
                    e.onError(Exception(response.errorBody()?.string()))
                }
            } catch (error: Exception) {
                Logger.d("6666  " + error.toString())

                e.onError(error)
            }

        }
                .subscribeOn(Schedulers.io())
    }

}