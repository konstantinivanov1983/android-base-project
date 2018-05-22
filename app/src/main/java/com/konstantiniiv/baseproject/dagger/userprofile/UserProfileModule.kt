package com.konstantiniiv.baseproject.dagger.userprofile

import com.konstantiniiv.baseproject.dagger.global.scope.FragmentScope
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.repository.userprofile.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 21.05.2018.
 */
@Module
class UserProfileModule {

    @FragmentScope
    @Provides
    fun provideUserProfileInteractor(userRepository: UserRepository): UserProfileInteractor
            = UserProfileInteractor(userProfileRepository = userRepository)

}