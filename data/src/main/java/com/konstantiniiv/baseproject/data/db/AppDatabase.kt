package com.konstantiniiv.baseproject.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.konstantiniiv.baseproject.data.db.dao.UserDao
import com.konstantiniiv.baseproject.data.model.UserEntity

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}