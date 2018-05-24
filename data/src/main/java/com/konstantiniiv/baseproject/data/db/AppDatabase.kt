package com.konstantiniiv.baseproject.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.konstantiniiv.baseproject.data.models.MovieData
import com.konstantiniiv.baseproject.data.models.UserData

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Database(entities = arrayOf(UserData::class, MovieData::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}