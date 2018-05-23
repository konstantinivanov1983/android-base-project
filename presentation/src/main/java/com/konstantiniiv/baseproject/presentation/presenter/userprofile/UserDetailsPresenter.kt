package com.konstantiniiv.baseproject.presentation.presenter.userprofile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.konstantiniiv.baseproject.presentation.presenter.BasePresenter
import com.konstantiniiv.baseproject.presentation.ui.userprofile.UserDetailsView

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

@InjectViewState
class UserDetailsPresenter(val userProfileInteractor: UserProfileInteractor)
    : BasePresenter<UserDetailsView>() {

    fun onShowUserProfileButtonPressed() {

        userProfileInteractor.getUserProfile()
    }

    private fun getUserProfile() {
        val userId = 77 // Only for Test



    }

}