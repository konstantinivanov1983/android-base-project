package com.konstantiniiv.baseproject.domain.userprofile

import com.konstantiniiv.baseproject.domain.model.Follower
import com.konstantiniiv.baseproject.domain.model.User
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
interface UserProfileRepo {

    fun getUserById(userId : Int) : Flowable<User>

    fun getUsers() : Single<List<User>>

    fun getFollowers() : Flowable<List<Follower>>
}