package com.konstantiniiv.baseproject.domain.model

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
data class MovieEntity(val id : Int = 0,
                       val title: String = "",
                       val runtime: Int = 0,
                       val averageVote : Int = 0)