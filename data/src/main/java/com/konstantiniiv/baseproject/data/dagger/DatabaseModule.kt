package com.konstantiniiv.baseproject.data.dagger

import android.arch.persistence.room.Room
import android.content.Context
import com.konstantiniiv.baseproject.data.db.AppDatabase
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
    fun provideDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java, "app-database").build()

}