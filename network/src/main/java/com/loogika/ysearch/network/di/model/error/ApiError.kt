package com.loogika.ysearch.network.di.model.error

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("message")
    var message: String?
)