package com.loogika.ysearch.core.util

sealed class ResultType<out T, out U> {
    data class Success<T>(
        val value: T
    ) : ResultType<T, Nothing>()

    data class Error<U>(
        val value: U
    ) : ResultType<Nothing, U>()

    object UnExpectedError : ResultType<Nothing, Nothing>()

    object EmptySuccess : ResultType<Nothing, Nothing>()
}