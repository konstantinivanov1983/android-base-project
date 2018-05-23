package com.konstantiniiv.baseproject.presentation.dagger.global

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module


/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Module
abstract class AppModule() {

    @Binds
    abstract fun bindApplication(app: Application) : Context

}