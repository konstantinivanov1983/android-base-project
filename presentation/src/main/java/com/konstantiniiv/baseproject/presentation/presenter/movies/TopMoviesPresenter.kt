package com.konstantiniiv.baseproject.presentation.presenter.movies

import com.arellomobile.mvp.InjectViewState
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.GetTopRatedMovies
import com.konstantiniiv.baseproject.presentation.presenter.BasePresenter
import com.konstantiniiv.baseproject.presentation.ui.movies.TopRatedMoviesView
import com.orhanobut.logger.Logger

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
@InjectViewState
class TopMoviesPresenter(val getTopRatedMovies: GetTopRatedMovies) : BasePresenter<TopRatedMoviesView>() {

    fun getTopMovies() {
        Logger.d("Start get Movies")
        disposeOnDestroy(getTopRatedMovies.observable()
                .subscribe({ t: List<MovieEntity>? ->
                    if (t != null) viewState.showMovies(t)
                    else Logger.d("List Movies is Null")
                },
                        { t: Throwable? ->
                            Logger.d("Error : " + t?.message)
                        }))

    }

}