package com.konstantiniiv.baseproject.presentation.presenter.userprofile

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.konstantiniiv.baseproject.domain.model.UserEntity
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.presentation.Screens
import com.konstantiniiv.baseproject.presentation.presenter.BasePresenter
import com.konstantiniiv.baseproject.presentation.ui.userprofile.UserDetailsView
import ru.terrakok.cicerone.Router

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

@InjectViewState
class UserDetailsPresenter(val userProfileInteractor: UserProfileInteractor,
                           val router : Router)
    : BasePresenter<UserDetailsView>() {

    fun onShowUserProfileButtonPressed() {
        getUserProfile()
    }

    private fun getUserProfile() {
        disposeOnDestroy(userProfileInteractor.getUserProfile()
                .subscribe({ users : List<UserEntity> ->
                    for (user in users) Log.d("Test1983", " User: " + user.id)


                },
                        { t -> Log.e("Test1983", " Error : " + t.localizedMessage) }))


    }

    fun moveToLoginActivity() {
        router.navigateTo(Screens.ACTIVITY_LOGIN, 1111)
    }

}