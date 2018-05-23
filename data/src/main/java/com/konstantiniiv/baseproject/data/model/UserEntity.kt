package com.konstantiniiv.baseproject.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Entity
data class UserEntity constructor(@PrimaryKey(autoGenerate = true)
                                  @ColumnInfo(name = "user_id") val id: Int,
                                  @ColumnInfo(name = "first_name") val firstName: String,
                                  @ColumnInfo(name = "last_name") val lastName: String,
                                  @ColumnInfo(name = "age") val age: Int)