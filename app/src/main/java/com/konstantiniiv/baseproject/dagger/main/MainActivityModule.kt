package com.konstantiniiv.baseproject.dagger.main

import com.konstantiniiv.baseproject.dagger.global.scope.ActivityScope
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.repository.userprofile.UserRepository
import com.konstantiniiv.baseproject.repository.userprofile.UserRepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideUserRepository() : UserRepository = UserRepositoryImpl()

}