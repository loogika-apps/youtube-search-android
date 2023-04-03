package com.loogika.ysearch.network.di.model.home

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("facebookLink") val facebookLink: String?,
    @SerializedName("twitterLink") val twitterLink: String?,
    @SerializedName("instagramLink") val instagramLink: String?,
    @SerializedName("tiktokLink") val tiktokLink: String?,
    @SerializedName("status") val status: Boolean?,

)