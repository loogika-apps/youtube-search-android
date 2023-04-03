package com.loogika.ysearch.search.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.loogika.ysearch.search.viewmodel.SearchViewModel
import com.loogika.ysearch.searchdata.model.SearchParams

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onNavigateToScreen: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background)
        ) {
            item {
                Text(text = "Search")
            }

        }
    }
    LaunchedEffect(Unit) {
        viewModel.search(SearchParams(
            text = "how are you",
            language = "En",
            accent = "En"
        ))
    }
}