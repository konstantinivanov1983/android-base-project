package com.konstantiniiv.baseproject.data.network

import com.konstantiniiv.baseproject.data.models.MovieData

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
data class TopRatedMoviesResponse(var page : Int = 0,
                                  var results : List<MovieData> = emptyList())