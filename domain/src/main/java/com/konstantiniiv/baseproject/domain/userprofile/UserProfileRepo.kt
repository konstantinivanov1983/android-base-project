package com.konstantiniiv.baseproject.domain.userprofile

import com.konstantiniiv.baseproject.domain.model.FollowerEntity
import com.konstantiniiv.baseproject.domain.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
interface UserProfileRepo {

    fun getUserById(userId : Int) : Flowable<UserEntity>

    fun getUsers() : Single<List<UserEntity>>

    fun getFollowers() : Flowable<List<FollowerEntity>>
}