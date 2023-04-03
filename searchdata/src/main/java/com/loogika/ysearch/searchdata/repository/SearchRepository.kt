package com.loogika.ysearch.searchdata.repository

import com.loogika.ysearch.network.di.model.search.NextVideoRequest
import com.loogika.ysearch.network.di.model.search.NextVideoResponse
import com.loogika.ysearch.network.di.model.search.SearchResponse
import com.loogika.ysearch.network.di.util.ErrorType
import com.loogika.ysearch.network.di.util.ResultType
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun search(text: String, language: String, accent: String)
            : Flow<ResultType<SearchResponse?, ErrorType>>

    suspend fun nextVideo(parameter: NextVideoRequest)
            : Flow<ResultType<SearchResponse?, ErrorType>>

}