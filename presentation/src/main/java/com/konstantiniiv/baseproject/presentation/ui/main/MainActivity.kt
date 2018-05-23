package com.konstantiniiv.baseproject.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.konstantiniiv.baseproject.presentation.R
import com.konstantiniiv.baseproject.presentation.Screens
import com.konstantiniiv.baseproject.presentation.ui.userprofile.UserDetailsFragment
import dagger.android.support.DaggerAppCompatActivity
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) router.navigateTo(Screens.FRAGMENT_USER_PROFILE)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private val navigator = object : SupportAppNavigator(this, R.id.main_container) {
        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
            return null
        }

        override fun createFragment(screenKey: String?, data: Any?): Fragment? =
                when (screenKey) {
                    Screens.FRAGMENT_USER_PROFILE -> UserDetailsFragment()
                    else -> null
                }

        override fun exit() {
            finish()
        }
    }
}