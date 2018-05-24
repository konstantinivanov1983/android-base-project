package com.konstantiniiv.baseproject.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.konstantiniiv.baseproject.data.models.MovieData
import io.reactivex.Flowable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */

@Dao
interface MovieDao{

    @Query("SELECT * FROM MovieData WHERE vote_average > 8 LIMIT 10")
    fun getTopRatedMovies() : Flowable<List<MovieData>>

}