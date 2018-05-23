package com.konstantiniiv.baseproject.domain.userprofile

import com.konstantiniiv.baseproject.domain.model.User
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class UserProfileInteractor @Inject constructor(val userProfileRepo: UserProfileRepo) {

    fun getUserProfile() = userProfileRepo.getUsers()


}