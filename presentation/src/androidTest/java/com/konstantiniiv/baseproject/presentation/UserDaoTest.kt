package com.konstantiniiv.baseproject

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.models.UserData
import io.reactivex.functions.Predicate
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */

@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    lateinit var dB: AppDatabase

    @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initDb() {
        dB = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun closeDb() {
        dB.close()
    }

    @Test
    fun insertAndGetUserById() {
        dB.userDao().insert(UserData(id = 23, firstName = "Konstantin", lastName = "Ivanov",
                age = 35))

        dB.userDao()
                .getUserById(23)
                .test()
                .assertValue(object : Predicate<UserData> {
                    override fun test(t: UserData): Boolean {
                        return t.id.equals(23) && t.firstName.equals("Konstantin")
                                && t.lastName.equals("Ivanov")
                    }
                })
    }

}