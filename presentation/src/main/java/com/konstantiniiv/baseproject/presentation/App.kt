package com.konstantiniiv.baseproject.presentation

import android.app.Activity
import com.konstantiniiv.baseproject.presentation.dagger.global.AppComponent
import com.konstantiniiv.baseproject.presentation.dagger.global.DaggerAppComponent
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class App : DaggerApplication() {

    companion object {
        lateinit var app: App
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        app = this
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .apply { appComponent = this }
    }
}