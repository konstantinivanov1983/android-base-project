package com.konstantiniiv.baseproject.data.mapper

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 22.05.2018.
 */
abstract class Mapper<T1, T2> {


    abstract fun map(value: T1): T2

    abstract fun reverseMap(value: T2): T1

    open fun map(values: List<T1>): List<T2> {
        val returnValues = ArrayList<T2>(values.size)
        values.forEach { t: T1 -> returnValues.add(map(t)) }
        return returnValues
    }

    open fun reverseMap(values: List<T2>): List<T1> {
        val returnValues = ArrayList<T1>(values.size)
        values.forEach { t: T2 -> returnValues.add(reverseMap(t)) }
        return returnValues
    }
}