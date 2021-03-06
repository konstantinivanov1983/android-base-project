package com.konstantiniiv.baseproject.data.userprofile

import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.models.UserData
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

/**
 * @see UserCache implementation.
 */

class UserCacheImpl @Inject constructor(val dataBase : AppDatabase) : UserCache{

    override fun get(userId: Int): Flowable<UserData> {
        return dataBase.userDao().getUserById(userId)
    }

    override fun put(userData: UserData) {
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