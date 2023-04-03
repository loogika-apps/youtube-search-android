package com.loogika.ysearch.network.exception

import com.loogika.ysearch.network.di.model.error.ErrorModel

class CustomException(
    val error: ErrorModel
): Throwable()