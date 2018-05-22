package com.konstantiniiv.baseproject.presentation.presenter.userprofile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.presentation.ui.userprofile.UserDetailsView

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

@InjectViewState
class UserDetailsPresenter(val userProfileInteractor: UserProfileInteractor)
    : MvpPresenter<UserDetailsView>() {


    fun onShowUserProfileButtonPressed() {
        userProfileInteractor.getUserProfile()
    }

}