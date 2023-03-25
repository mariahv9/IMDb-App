package com.example.imdbapp.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _signUpEnable = MutableLiveData<Boolean>()
    val signUpEnable: LiveData<Boolean> = _signUpEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _signUpEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    fun onNameChanged(name: String) {
        _name.value = name
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isValidPassword(password: String): Boolean = password.length > 6

    suspend fun onSignUpSelected() {
        _isLoading.value = true
        delay(400)
        _isLoading.value = false
    }
}