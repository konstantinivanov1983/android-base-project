package com.konstantiniiv.baseproject.presentation.ui.userprofile

import com.arellomobile.mvp.MvpView
import com.konstantiniiv.baseproject.model.userprofile.Follower

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
interface UserFollowersView: MvpView{

    fun showFollowers(followers: List<Follower>)

}