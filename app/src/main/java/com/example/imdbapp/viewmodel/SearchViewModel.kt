package com.example.imdbapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun onTextChanged(text: String) {
        _text.value = text
    }
}
