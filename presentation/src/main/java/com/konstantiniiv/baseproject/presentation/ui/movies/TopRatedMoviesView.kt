package com.konstantiniiv.baseproject.presentation.ui.movies

import com.arellomobile.mvp.MvpView
import com.konstantiniiv.baseproject.domain.model.MovieEntity

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */
interface TopRatedMoviesView : MvpView{

    fun showMovies(movies : List<MovieEntity>)

}