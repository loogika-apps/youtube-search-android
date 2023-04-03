package com.loogika.ysearch.network.di.model.schedule

import com.google.gson.annotations.SerializedName

data class ScheduleResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("dateAt") val dateAt: String?,
    @SerializedName("duration") val duration: String?,
    @SerializedName("status") val status: Boolean?
)