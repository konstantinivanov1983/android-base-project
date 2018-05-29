package com.konstantiniiv.baseproject.data.db

import android.arch.persistence.room.*
import com.konstantiniiv.baseproject.data.models.MovieData

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(movie: MovieData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(movies: List<MovieData>)

    @Delete
    abstract fun delete(movie: MovieData): Int

    @Query("DELETE FROM MovieData")
    abstract fun deleteAll()

    @Query("SELECT * FROM MovieData")
    abstract fun getAll(): List<MovieData>

    @Query("SELECT * FROM MovieData WHERE movie_id=:moviId")
    abstract fun get(moviId: Int): MovieData?

    @Delete
    abstract fun delete(movies: List<MovieData>): Int

}