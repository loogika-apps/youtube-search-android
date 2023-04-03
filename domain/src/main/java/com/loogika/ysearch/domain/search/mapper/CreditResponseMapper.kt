package com.loogika.ysearch.domain.search.mapper

import com.loogika.ysearch.network.di.model.search.ItemResponse
import com.loogika.ysearch.network.di.model.search.NextVideoResponse
import com.loogika.ysearch.network.di.model.search.SearchResponse
import com.loogika.ysearch.searchdata.model.ItemResult
import com.loogika.ysearch.searchdata.model.NextVideoResult
import com.loogika.ysearch.searchdata.model.SearchResult

internal fun SearchResponse.toSearchResult() =
    SearchResult(
        items = items.map { it.toItemResult() },
        total = total,
        nextPage = nextPage.toNextVideoResult()
    )

internal fun ItemResponse.toItemResult() =
    ItemResult(
        id = id,
        type = type,
        title = title,
        start = start
    )

internal fun NextVideoResponse.toNextVideoResult() =
    NextVideoResult(
        nextPageToken = nextPageToken
    )