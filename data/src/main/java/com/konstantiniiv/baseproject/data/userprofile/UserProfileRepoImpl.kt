package com.konstantiniiv.baseproject.data.userprofile

import com.konstantiniiv.baseproject.data.mapper.UserMapper
import com.konstantiniiv.baseproject.domain.model.User
import com.konstantiniiv.baseproject.data.model.UserEntity
import com.konstantiniiv.baseproject.domain.model.Follower
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

    override fun getUserById(userId: Int): Flowable<User> {
        return userCache.get(userId).map { t: UserEntity -> userMapper.map(t) }
    }

    override fun getUsers(): Single<List<User>> {
        return Single.just(listOf(User(id = 14), User(id = 15)))
    }

    override fun getFollowers(): Flowable<List<Follower>> {
        throw UnsupportedOperationException("not implemented")
    }
}