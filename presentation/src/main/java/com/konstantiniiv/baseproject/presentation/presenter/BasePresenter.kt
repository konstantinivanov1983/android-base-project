package com.konstantiniiv.baseproject.presentation.presenter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 22.05.2018.
 */

open class BasePresenter<View: MvpView> : MvpPresenter<View>() {

    private val compositeDisposable = CompositeDisposable()

    protected fun disposeOnDestroy(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}