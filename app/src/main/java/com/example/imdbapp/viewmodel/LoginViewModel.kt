package com.example.imdbapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.common.Resource
import com.example.imdbapp.domain.usecase.GetLoginUseCase
import com.example.imdbapp.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase,
) : ViewModel() {
    private val _loginState = MutableStateFlow(UserState())
    var isUserName by mutableStateOf(true)
    var isPassword by mutableStateOf(true)

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

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
