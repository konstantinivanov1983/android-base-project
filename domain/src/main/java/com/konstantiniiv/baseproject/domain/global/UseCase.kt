package com.konstantiniiv.baseproject.domain.global

import io.reactivex.Observable

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 24.05.2018.
 */
abstract class UseCase<T>(private val transformer: Transformer<T>) {

    abstract fun createObservable(data: Map<String, Any>? = null): Observable<T>

    fun observable(withData: Map<String, Any>? = null): Observable<T> {
        return createObservable(withData).compose(transformer)
    }

}