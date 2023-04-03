package com.loogika.ysearch.searchdata.model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("items") val items: List<ItemResult> = emptyList(),
    @SerializedName("total") val total: Int,
    @SerializedName("nextPage") val nextPage: NextVideoResult,
)

data class ItemResult(
    @SerializedName("id") val id: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("start") val start: String,
)