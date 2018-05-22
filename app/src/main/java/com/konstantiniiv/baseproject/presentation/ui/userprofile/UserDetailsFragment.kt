package com.konstantiniiv.baseproject.presentation.ui.userprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.model.userprofile.User
import com.konstantiniiv.baseproject.presentation.presenter.userprofile.UserDetailsPresenter
import com.konstantiniiv.baseproject.presentation.ui.global.BaseFragment
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
class UserDetailsFragment : BaseFragment(), UserDetailsView {

    @Inject
    lateinit var userProfileInteractor: UserProfileInteractor

    @InjectPresenter
    lateinit var presenter: UserDetailsPresenter

    @ProvidePresenter
    fun providePresenter() = UserDetailsPresenter(userProfileInteractor= userProfileInteractor)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun showUserProfile(user: User) {
        throw UnsupportedOperationException("not implemented")
    }
}