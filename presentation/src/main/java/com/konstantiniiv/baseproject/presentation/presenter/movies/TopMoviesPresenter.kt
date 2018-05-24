package com.konstantiniiv.baseproject.presentation.presenter.movies

import com.arellomobile.mvp.InjectViewState
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.MoviesInteractor
import com.konstantiniiv.baseproject.presentation.presenter.BasePresenter
import com.konstantiniiv.baseproject.presentation.ui.movies.TopRatedMoviesView
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
@InjectViewState
class TopMoviesPresenter(val interactor: MoviesInteractor) : BasePresenter<TopRatedMoviesView>() {

    fun getTopMovies() {
        disposeOnDestroy(interactor.getTopRatedMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: List<MovieEntity>? ->
                    if (t != null) viewState.showMovies(t)
                    else Logger.d("List Movies is Null")
                },
                        { t: Throwable? ->

                        }))

    }

}