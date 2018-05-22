package com.konstantiniiv.baseproject.repository.userprofile

import com.konstantiniiv.baseproject.model.userprofile.Follower

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class FollowersRepositoryImpl : FollowersRepository {

    override fun getFollowers(): List<Follower> {
        val followers = arrayListOf(
                Follower(id = 11, name = "Misha", age = 23),
                Follower(id = 12, name = "Vasya", age = 25),
                Follower(id = 13, name = "Dima", age = 32),
                Follower(id = 14, name = "Edik", age = 51))
        return followers
    }
}