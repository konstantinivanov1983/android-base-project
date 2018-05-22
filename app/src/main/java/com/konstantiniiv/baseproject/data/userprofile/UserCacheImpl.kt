package com.konstantiniiv.baseproject.data.userprofile

import com.konstantiniiv.baseproject.model.userprofile.UserEntity
import io.reactivex.Flowable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

/**
 * @see UserCache implementation.
 */

class UserCacheImpl : UserCache{

    override fun get(userId: Int): Flowable<UserEntity> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun put(userEntity: UserEntity) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isCached(userId: Int): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun isExpired(): Boolean {
        throw UnsupportedOperationException("not implemented")
    }

    override fun evictAll() {
        throw UnsupportedOperationException("not implemented")
    }
}