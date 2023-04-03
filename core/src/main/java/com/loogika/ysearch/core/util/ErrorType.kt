package com.loogika.ysearch.core.util


sealed class ErrorType {
    data class Error(
        val errorModel: ErrorModel
    ) : ErrorType()

    data class Exception(
        val throwable: Throwable
    ) : ErrorType()
}