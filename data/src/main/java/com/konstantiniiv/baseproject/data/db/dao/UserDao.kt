package com.konstantiniiv.baseproject.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.konstantiniiv.baseproject.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity WHERE user_id=:userId")
    fun getUserById(userId: Int): Flowable<UserEntity>

    @Query("SELECT * FROM UserEntity")
    fun getUsers() : Single<List<UserEntity>>

    @Insert
    fun insert(user : UserEntity)

}