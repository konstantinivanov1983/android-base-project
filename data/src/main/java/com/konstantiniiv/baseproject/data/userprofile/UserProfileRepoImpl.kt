package com.konstantiniiv.baseproject.data.userprofile

import com.konstantiniiv.baseproject.data.mapper.UserMapper
import com.konstantiniiv.baseproject.domain.model.UserEntity
import com.konstantiniiv.baseproject.data.models.UserData
import com.konstantiniiv.baseproject.domain.model.FollowerEntity
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileRepo
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
class UserProfileRepoImpl @Inject constructor(val userCache : UserCache,
                                              val userMapper: UserMapper) : UserProfileRepo {

    override fun getUserById(userId: Int): Flowable<UserEntity> {
        return userCache.get(userId).map { t: UserData -> userMapper.map(t) }
    }

    override fun getUsers(): Single<List<UserEntity>> {
        return Single.just(listOf(UserEntity(id = 14), UserEntity(id = 15)))
    }

    override fun getFollowers(): Flowable<List<FollowerEntity>> {
        throw UnsupportedOperationException("not implemented")
    }
}