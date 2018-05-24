package com.konstantiniiv.baseproject.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.konstantiniiv.baseproject.data.models.UserData
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM UserData WHERE user_id=:userId")
    fun getUserById(userId: Int): Flowable<UserData>

    @Query("SELECT * FROM UserData")
    fun getUsers() : Single<List<UserData>>

    @Insert
    fun insert(user : UserData)

}