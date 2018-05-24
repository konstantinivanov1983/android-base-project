package com.konstantiniiv.baseproject.presentation.ui.userprofile

import com.arellomobile.mvp.MvpView
import com.konstantiniiv.baseproject.domain.model.UserEntity

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
interface UserDetailsView : MvpView{

    fun showUserProfile(user: UserEntity)

}