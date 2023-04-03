package com.loogika.ysearch.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.loogika.ysearch.core.viewmodel.BaseViewModel
import com.loogika.ysearch.domain.search.SearchUseCase
import com.loogika.ysearch.domain.viewstate.extension.*
import com.loogika.ysearch.search.uistate.SearchUiState
import com.loogika.ysearch.searchdata.model.SearchParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
) : BaseViewModel() {

    var searchUiState = MutableStateFlow(SearchUiState.Empty)
        private set

    fun search(params: SearchParams) {
        viewModelScope.launch {
            searchUseCase(params) collectAsSuccess {
                searchUiState.value = SearchUiState(
                    isLoading = false, searchResult = it
                )

            } collectAsUnAuthorized {

            } collectAsFailureErrorModel {
                searchUiState.value = SearchUiState(
                    isLoading = false
                )
            } collectAsFailure {
                searchUiState.value = SearchUiState(
                    isLoading = false
                )
            } collectAsErrorConnection {
                searchUiState.value = SearchUiState(
                    isLoading = false
                )
            }
        }
    }
}