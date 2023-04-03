package com.loogika.ysearch.search.uistate

import com.loogika.ysearch.searchdata.model.SearchResult

data class SearchUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isErrorConnection: Boolean = false,
    val searchResult: SearchResult? = null
) {
    companion object {
        val Empty = SearchUiState()
    }
}
