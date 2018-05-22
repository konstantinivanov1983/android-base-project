package com.konstantiniiv.baseproject.domain.userprofile

import com.konstantiniiv.baseproject.model.userprofile.Follower
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class UserFollowersInteractor @Inject constructor(val followersInteractor: UserFollowersInteractor) {

    fun getFollowers(): List<Follower> = followersInteractor.getFollowers()


}