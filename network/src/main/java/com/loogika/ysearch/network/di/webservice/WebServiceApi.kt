package com.loogika.ysearch.network.di.webservice

import com.loogika.ysearch.network.di.model.search.NextVideoRequest
import com.loogika.ysearch.network.di.model.search.NextVideoResponse
import com.loogika.ysearch.network.di.model.search.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface WebServiceApi {
    companion object {
        const val API_VERSION = "v1/"
    }

    @GET("${API_VERSION}videos/search")
    suspend fun search(
        @Query("text") text: String,
        @Query("lan") language: String,
        @Query("ac") accent: String,
    ) : Response<SearchResponse>

    @POST("${API_VERSION}videos/next")
    suspend fun nextVideo(
        @Body data: NextVideoRequest
    ) : Response<SearchResponse>
}