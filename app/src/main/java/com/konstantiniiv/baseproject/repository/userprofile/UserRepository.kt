package com.konstantiniiv.baseproject.repository.userprofile

import com.konstantiniiv.baseproject.model.userprofile.User
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
interface UserRepository {

    fun getUserById(userId : Int) : Single<User>

    fun getUsers() : Single<List<User>>
}