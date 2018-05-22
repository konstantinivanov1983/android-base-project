package com.konstantiniiv.baseproject.repository.userprofile

import com.konstantiniiv.baseproject.model.userprofile.Follower

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
interface FollowersRepository {

    fun getFollowers() : List<Follower>

}