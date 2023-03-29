package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.example.imdbapp.ui.components.BottomBar
import com.example.imdbapp.ui.components.CardRecyclerSearch
import com.example.imdbapp.ui.components.field.SearchTextField
import com.example.imdbapp.viewmodel.MovieViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    movieViewModel: MovieViewModel
) {
    val text = remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        bottomBar = { BottomBar(Modifier) }
    ) {
        Column() {
            SearchTextField(state = text)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                itemsIndexed(movieViewModel.searchMovie(text.value.text)) { _, movie ->
                    CardRecyclerSearch(movie = movie)
                }
            }
        }
    }
}
