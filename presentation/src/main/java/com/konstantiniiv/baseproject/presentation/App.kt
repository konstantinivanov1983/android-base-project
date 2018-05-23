package com.konstantiniiv.baseproject

import android.app.Activity
import com.konstantiniiv.baseproject.dagger.global.AppComponent
import com.konstantiniiv.baseproject.dagger.global.DaggerAppComponent
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
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .apply { appComponent = this }
    }
}