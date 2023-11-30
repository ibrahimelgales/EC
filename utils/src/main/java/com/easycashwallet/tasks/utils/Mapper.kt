package com.easycashwallet.tasks.utils

interface Mapper<T, R> {
    fun mapToFirst(model: R): T?
    fun mapToSecond(model: T?): R?
}
