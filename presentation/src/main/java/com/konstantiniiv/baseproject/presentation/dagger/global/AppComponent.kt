package com.konstantiniiv.baseproject.presentation.dagger.global

import com.konstantiniiv.baseproject.App
import com.konstantiniiv.baseproject.data.dagger.DatabaseModule
import com.konstantiniiv.baseproject.data.dagger.MapperModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
@Singleton
@Component(modules = [
    AppModule::class,
    NavigationModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    DatabaseModule::class,
    MapperModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}