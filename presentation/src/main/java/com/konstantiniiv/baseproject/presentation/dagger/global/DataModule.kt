package com.konstantiniiv.baseproject.presentation.dagger.global

import android.arch.persistence.room.Room
import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.data.movies.CachedMoviesDataStore
import com.konstantiniiv.baseproject.data.movies.MemoryMoviesCache
import com.konstantiniiv.baseproject.data.movies.RemoteMoviesDataStore
import com.konstantiniiv.baseproject.data.movies.RoomMoviesCache
import com.konstantiniiv.baseproject.data.network.Api
import com.konstantiniiv.baseproject.domain.movies.MoviesCache
import com.konstantiniiv.baseproject.domain.movies.MoviesDataStore
import com.konstantiniiv.baseproject.presentation.App
import com.konstantiniiv.baseproject.presentation.DI
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 28.05.2018.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDatabase(application: App): AppDatabase = Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java, "app-database").build()


    @Singleton
    @Provides
    @Named(DI.inMemoryMoviesCache)
    fun provideInMemoryCache(): MoviesCache = MemoryMoviesCache()

    @Singleton
    @Provides
    @Named(DI.inRoomMoviesCache)
    fun provideInRoomMovieCache(movieMapper: MovieMapper, appDatabase: AppDatabase)
            : MoviesCache = RoomMoviesCache(movieMapper = movieMapper,
            database = appDatabase)

    @Singleton
    @Provides
    @Named(DI.inRemoteMoviesDataStore)
    fun provideRemoteMovieDataStore(api: Api, movieMapper: MovieMapper)
            : MoviesDataStore = RemoteMoviesDataStore(api = api, movieMapper = movieMapper)

    @Singleton
    @Provides
    @Named(DI.inCacheMoviesDataStore)
    fun provideCachedMoviesDataStore(moviesCache: MoviesCache)
            : MoviesDataStore = CachedMoviesDataStore(cache = moviesCache)

}