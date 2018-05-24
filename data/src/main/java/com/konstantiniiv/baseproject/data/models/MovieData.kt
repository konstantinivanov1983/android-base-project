package com.konstantiniiv.baseproject.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
@Entity
data class MovieData(
        @PrimaryKey
        @ColumnInfo(name = "movie_id")
        @SerializedName("id")
        var id: Int = 0,

        @ColumnInfo(name = "imdb_id")
        @SerializedName("imdb_id")
        var imdbId: Int = 0,

        @ColumnInfo(name = "original_title")
        @SerializedName("original_title")
        var nameOriginal: String = "",

        @ColumnInfo(name = "runtime")
        @SerializedName("runtime")
        var runtime: Int = 0,

        @ColumnInfo(name = "vote_average")
        @SerializedName("vote_average")
        var voteAverage: Float = 0f

)