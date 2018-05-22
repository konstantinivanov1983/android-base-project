package com.konstantiniiv.baseproject.repository.userprofile

import com.konstantiniiv.baseproject.model.userprofile.User
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
class UserRepositoryImpl : UserRepository {

    override fun getUserById(userId: Int): Single<User> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun getUsers(): Single<List<User>> {
        throw UnsupportedOperationException("not implemented")
    }
}