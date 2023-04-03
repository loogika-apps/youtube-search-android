package com.loogika.ysearch.network.di.model.proposal

import com.google.gson.annotations.SerializedName

data class ProposalResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String?,
    @SerializedName("shortDescription") val shortDescription: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("likes") val likes: Int?,
    @SerializedName("status") val status: Boolean?,
    @SerializedName("url") val url: String?,
)