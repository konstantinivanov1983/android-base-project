package com.konstantiniiv.baseproject.data.mapper

import com.konstantiniiv.baseproject.data.model.UserEntity
import com.konstantiniiv.baseproject.domain.model.User

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 22.05.2018.
 */
class UserMapper : Mapper<UserEntity, User>() {

    override fun map(value: UserEntity): User {
        return User(id = value.id, age = value.age,
                lastName = value.lastName, firstName = value.lastName)
    }

    override fun reverseMap(value: User): UserEntity {
        return UserEntity(id = value.id, firstName = value.firstName,
                lastName = value.lastName, age = value.age)
    }
}