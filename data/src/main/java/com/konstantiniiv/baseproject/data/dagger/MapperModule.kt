package com.konstantiniiv.baseproject.data.dagger

import com.konstantiniiv.baseproject.data.mapper.UserMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 22.05.2018.
 */
@Module
class MapperModule {

    @Singleton
    @Provides
    fun provideUserMapper() : UserMapper = UserMapper()
}