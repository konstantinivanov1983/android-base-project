package com.konstantiniiv.baseproject.data.network

import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
interface Api {

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") api_key: String)
            : Call<TopRatedMoviesResponse>

}