package com.konstantiniiv.baseproject.data.userprofile

import com.konstantiniiv.baseproject.data.model.UserEntity
import io.reactivex.Flowable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

/**
 * An interface representing a user Cache.
 */
interface UserCache {

    /**
     * Gets an {@link rx.Flowable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id to retrieve data.
     */
    fun get(userId : Int) : Flowable<UserEntity>

    /**
     * Puts an element into the cache.
     *
     * @param userEntity Element to insert in the cache.
     */
    fun put(userEntity : UserEntity)

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @param userId The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(userId : Int) : Boolean

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired() : Boolean

    /**
     * Evict all elements of the cache.
     */
    fun evictAll()
}