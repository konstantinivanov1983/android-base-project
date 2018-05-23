package com.konstantiniiv.baseproject.presentation.dagger.global

import com.konstantiniiv.baseproject.dagger.global.scope.ActivityScope
import com.konstantiniiv.baseproject.presentation.dagger.main.MainActivityModule
import com.konstantiniiv.baseproject.presentation.dagger.main.MainFragmentsBindingModule
import com.konstantiniiv.baseproject.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class,
        MainFragmentsBindingModule::class])
    abstract fun mainActivity(): MainActivity

}