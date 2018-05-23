package com.konstantiniiv.baseproject.presentation.dagger.main

import com.konstantiniiv.baseproject.dagger.global.scope.FragmentScope
import com.konstantiniiv.baseproject.presentation.ui.userprofile.UserDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Module
abstract class MainFragmentsBindingModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun userProfileFragment(): UserDetailsFragment

}