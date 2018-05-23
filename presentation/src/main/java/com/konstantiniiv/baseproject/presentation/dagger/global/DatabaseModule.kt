package com.konstantiniiv.baseproject.presentation.dagger.global

import android.arch.persistence.room.Room
import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.presentation.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: App) = Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "app-database").build()

}