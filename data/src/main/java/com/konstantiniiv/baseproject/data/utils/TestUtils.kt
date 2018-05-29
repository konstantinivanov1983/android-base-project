package com.konstantiniiv.baseproject.data.utils

import com.konstantiniiv.baseproject.data.models.MovieData

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 28.05.2018.
 */
class TestUtils {

    companion object {

        fun getTestMovieData(id: Int): MovieData {
            return MovieData(id = id,
                    nameOriginal = "Title#$id",
                    voteAverage = 7.0f,
                    runtime = 110,
                    imdbId = id
            )
        }

        fun getListOfMovieData(): List<MovieData> {
            return (0..4).map {
                MovieData(id = it,
                        voteAverage = 7.0f,
                        imdbId = it,
                        runtime = 110,
                        nameOriginal = "Title#$it"
                        )
            }
        }
    }
}