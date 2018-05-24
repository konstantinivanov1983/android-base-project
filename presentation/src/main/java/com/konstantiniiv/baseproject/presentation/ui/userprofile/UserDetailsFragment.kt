package com.konstantiniiv.baseproject.presentation.ui.userprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.domain.model.UserEntity
import com.konstantiniiv.baseproject.presentation.R
import com.konstantiniiv.baseproject.presentation.presenter.userprofile.UserDetailsPresenter
import com.konstantiniiv.baseproject.presentation.ui.global.BaseFragment
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
class UserDetailsFragment : BaseFragment(), UserDetailsView {

    @Inject
    lateinit var userProfileInteractor: UserProfileInteractor

    @Inject
    lateinit var router: Router

    @InjectPresenter
    lateinit var presenter: UserDetailsPresenter

    @ProvidePresenter
    fun providePresenter() = UserDetailsPresenter(userProfileInteractor = userProfileInteractor,
            router = router)

    lateinit var btnShow : Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_userdetails, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnShow = view.findViewById(R.id.btn_show)
        btnShow.setOnClickListener { _ -> presenter.onShowUserProfileButtonPressed() }
    }

    override fun showUserProfile(user: UserEntity) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun onDestroyView() {
        btnShow.setOnClickListener(null)
        super.onDestroyView()
    }
}