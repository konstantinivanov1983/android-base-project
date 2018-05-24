package com.konstantiniiv.baseproject.data.mapper

import com.konstantiniiv.baseproject.data.models.UserData
import com.konstantiniiv.baseproject.domain.model.UserEntity

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 22.05.2018.
 */
class UserMapper : Mapper<UserData, UserEntity>() {

    override fun map(value: UserData): UserEntity {
        return UserEntity(id = value.id, age = value.age,
                lastName = value.lastName, firstName = value.lastName)
    }

    override fun reverseMap(value: UserEntity): UserData {
        return UserData(id = value.id, firstName = value.firstName,
                lastName = value.lastName, age = value.age)
    }
}