package com.example.imdbapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.common.Resource
import com.example.imdbapp.domain.usecase.GetLoginUseCase
import com.example.imdbapp.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase
) : ViewModel() {
    private val _loginState = MutableStateFlow(UserState())
    var userState = _loginState.asStateFlow()
    var isUserName by mutableStateOf(true)
    var isPassword by mutableStateOf(true)

    fun signIn(onNavigate: () -> Unit, email: String, password: String) {
        isUserName = email.isNotEmpty()
        isPassword = password.isNotEmpty() && password.length > 8
        when {
            isUserName && isPassword -> {
                viewModelScope.launch {
                    getLoginUseCase.login(email, password)
                    getLoginUseCase.isLogged().apply {
                        Resource.Success {
                            _loginState.update { it }
                        }
                    }
                    onNavigate()
                }
            }
        }
    }
}
