package com.konstantiniiv.baseproject.domain.userprofile

import com.konstantiniiv.baseproject.model.userprofile.User
import com.konstantiniiv.baseproject.repository.userprofile.UserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class UserProfileInteractor @Inject constructor(val userProfileRepository: UserRepository) {

    fun getUserProfile() = userProfileRepository.getUsers()

}