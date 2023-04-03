package com.loogika.ysearch.domain.search

import com.loogika.ysearch.domain.search.mapper.toSearchResult
import com.loogika.ysearch.domain.usecase.FlowUseCase
import com.loogika.ysearch.domain.viewstate.UIState
import com.loogika.ysearch.network.di.util.ErrorType
import com.loogika.ysearch.network.di.util.ResultType
import com.loogika.ysearch.searchdata.datasource.SearchDataSource
import com.loogika.ysearch.searchdata.model.SearchParams
import com.loogika.ysearch.searchdata.model.SearchResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchDataSource: SearchDataSource,
) : FlowUseCase<SearchParams, SearchResult?>() {
    override suspend fun execute(parameters: SearchParams)
            : Flow<UIState<SearchResult?>> =
        searchDataSource.search(parameters.text, parameters.language, parameters.accent)
            .map { result ->
                if (result is ResultType.Success) {
                    return@map UIState.Success(
                        result.value?.toSearchResult()
                    )
                }

                if (result is ResultType.Error) {
                    val error = result.value
                    if (error is ErrorType.Error) {
                        return@map UIState.FailureErrorModel(error.errorModel)
                    }
                    if (error is ErrorType.Exception) {
                        return@map UIState.Failure(error)
                    }
                    if (error is ErrorType.NetworkConnectionHttpException) {
                        return@map UIState.ConnectionError
                    }
                    if (error is ErrorType.NetworkAuthHttpException) {
                        return@map UIState.UnAuthorized
                    }
                }

                UIState.UnExpectedError
            }
}