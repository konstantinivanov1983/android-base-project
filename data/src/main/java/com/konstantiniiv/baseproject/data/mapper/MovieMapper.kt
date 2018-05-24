package com.konstantiniiv.baseproject.data.mapper

import com.konstantiniiv.baseproject.data.models.MovieData
import com.konstantiniiv.baseproject.domain.model.MovieEntity

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
class MovieMapper : Mapper<MovieData, MovieEntity>() {

    override fun map(value: MovieData) = MovieEntity(id = value.id, averageVote = value.voteAverage,
            runtime = value.runtime, title = value.nameOriginal)

    override fun reverseMap(value: MovieEntity): MovieData {
        throw UnsupportedOperationException("not implemented")
    }
}