package com.konstantiniiv.baseproject.presentation.presenter.userprofile

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.konstantiniiv.baseproject.domain.model.User
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
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
        getUserProfile()
    }

    private fun getUserProfile() {
        disposeOnDestroy(userProfileInteractor.getUserProfile()
                .subscribe({ users : List<User> ->
                    for (user in users) Log.d("Test1983", " User: " + user.id)
                },
                        { t -> Log.e("Test1983", " Error : " + t.localizedMessage) }))


    }

}