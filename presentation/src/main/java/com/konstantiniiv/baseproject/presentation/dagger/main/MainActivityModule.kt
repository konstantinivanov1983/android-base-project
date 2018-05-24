package com.konstantiniiv.baseproject.presentation.dagger.main

import com.konstantiniiv.baseproject.dagger.global.scope.ActivityScope
import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.mapper.MovieMapper
import com.konstantiniiv.baseproject.data.mapper.UserMapper
import com.konstantiniiv.baseproject.data.movies.RemoteMoviesDataStore
import com.konstantiniiv.baseproject.data.movies.MovieCache
import com.konstantiniiv.baseproject.data.movies.CachedMoviesDataStore
import com.konstantiniiv.baseproject.data.movies.MoviesRepoImpl
import com.konstantiniiv.baseproject.data.userprofile.UserCache
import com.konstantiniiv.baseproject.data.userprofile.UserCacheImpl
import com.konstantiniiv.baseproject.data.userprofile.UserProfileRepoImpl
import com.konstantiniiv.baseproject.domain.movies.MoviesInteractor
import com.konstantiniiv.baseproject.domain.movies.MoviesRepo
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileInteractor
import com.konstantiniiv.baseproject.domain.userprofile.UserProfileRepo
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
    fun provideUserProfileInteractor(userRepository: UserProfileRepo)
            : UserProfileInteractor = UserProfileInteractor(userProfileRepo = userRepository)

    @ActivityScope
    @Provides
    fun provideUserRepository(userCache: UserCache, userMapper: UserMapper)
            : UserProfileRepo = UserProfileRepoImpl(userCache = userCache, userMapper = userMapper)

    @ActivityScope
    @Provides
    fun provideUserCache(database: AppDatabase)
            : UserCache = UserCacheImpl(dataBase = database)

    @ActivityScope
    @Provides
    fun provideMovieCache(database: AppDatabase)
            : MovieCache = CachedMoviesDataStore(database = database)

    @ActivityScope
    @Provides
    fun provideMovieRepo(movieCache: RemoteMoviesDataStore, movieMapper: MovieMapper)
            : MoviesRepo = MoviesRepoImpl(movieCache = movieCache, movieMapper = movieMapper)

    @ActivityScope
    @Provides
    fun provideMovieInteractor(moviesRepo: MoviesRepo)
            : MoviesInteractor = MoviesInteractor(moviesRepo = moviesRepo)


}