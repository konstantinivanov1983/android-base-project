package com.konstantiniiv.baseproject.domain.userprofile

import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class UserProfileInteractor @Inject constructor(val userProfileRepo: UserProfileRepo) {

    fun getUserProfile() = userProfileRepo.getUsers()

    fun getFollowers() = userProfileRepo.getFollowers()

}