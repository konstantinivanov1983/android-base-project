package com.konstantiniiv.baseproject.presentation.ui.global

import android.content.Context
import android.support.v4.app.Fragment
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
open class BaseFragment constructor() : MvpAppCompatFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector
}