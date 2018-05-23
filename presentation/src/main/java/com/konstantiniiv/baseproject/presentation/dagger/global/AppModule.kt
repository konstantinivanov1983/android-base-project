package com.konstantiniiv.baseproject.dagger.global

import android.app.Application
import android.content.Context
import com.konstantiniiv.baseproject.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Module
abstract class AppModule() {

    @Binds
    abstract fun bindContext(app: Application) : Context

}