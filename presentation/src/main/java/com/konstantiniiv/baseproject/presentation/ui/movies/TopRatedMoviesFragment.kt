package com.konstantiniiv.baseproject.presentation.ui.movies

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.konstantiniiv.baseproject.domain.model.MovieEntity
import com.konstantiniiv.baseproject.domain.movies.GetTopRatedMovies
import com.konstantiniiv.baseproject.presentation.R
import com.konstantiniiv.baseproject.presentation.presenter.movies.TopMoviesPresenter
import com.konstantiniiv.baseproject.presentation.ui.global.BaseFragment
import com.orhanobut.logger.Logger
import java.util.*
import javax.inject.Inject

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 23.05.2018.
 */

class TopRatedMoviesFragment : BaseFragment(), TopRatedMoviesView {

    @Inject
    lateinit var getTopRatedMovies: GetTopRatedMovies

    @InjectPresenter
    lateinit var presenter: TopMoviesPresenter

    @ProvidePresenter
    fun providePresenter() = TopMoviesPresenter(getTopRatedMovies)

    lateinit var rvMovies: RecyclerView
    lateinit var btnShowMovies: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_topmovies, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMovies = view.findViewById(R.id.recycler_movies)
        btnShowMovies = view.findViewById(R.id.btn_show_movies)
        btnShowMovies.setOnClickListener { _ -> presenter.getTopMovies() }
        val lm = LinearLayoutManager(activity)
        rvMovies.layoutManager = lm
    }

    override fun showMovies(movies: List<MovieEntity>) {
        Logger.d("Get Top Movies " + movies.size)
        if (movies.isNotEmpty()) {
            for(movie in movies) {
                Logger.d(String.format(Locale.ENGLISH, "title:%s, votes:%f",
                        movie.title, movie.averageVote))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        btnShowMovies.setOnClickListener(null)
    }
}