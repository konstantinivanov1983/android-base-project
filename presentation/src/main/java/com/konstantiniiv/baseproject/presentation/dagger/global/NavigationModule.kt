package com.konstantiniiv.baseproject.dagger.global

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Module
class NavigationModule() {

    val cicerone: Cicerone<Router>

    init {
        cicerone = Cicerone.create()
    }

    @Singleton
    @Provides
    fun provideRouter() : Router = cicerone.router

    @Singleton
    @Provides
    fun provideNavigatorHolder() : NavigatorHolder = cicerone.navigatorHolder

}