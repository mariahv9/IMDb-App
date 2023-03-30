package com.example.imdbapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.domain.usecase.GetSignUpUseCase
import com.example.imdbapp.mapper.toUserModel
import com.example.imdbapp.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    //private val getSignUpUseCase: GetSignUpUseCase
) : ViewModel() {
    var validatedPassword by mutableStateOf(true)
    var isNamed by mutableStateOf(true)
    var isEmail by mutableStateOf(true)
    var isPassword by mutableStateOf(true)
    private val _signUpState = MutableStateFlow(UserState())
    private val _signUpEnable = MutableLiveData<Boolean>()
    val signUpEnable: LiveData<Boolean> = _signUpEnable

    private fun isValidPassword(password: String): Boolean {
        return if (password.isNotEmpty()) {
            val uppercase = Regex("[A-Z]").containsMatchIn(password)
            val lowercase = Regex("[a-z]").containsMatchIn(password)
            val number = Regex("\\d").containsMatchIn(password)
            val characters = Regex("[!@#\$%^&*(),.?\":{}|<>]").containsMatchIn(password)
            val length = password.length > 8
            uppercase && lowercase && number && characters && length
        } else {
            false
        }
    }

    fun signUp() {
        isNamed = _signUpState.value.email.isNotEmpty()
        isEmail = _signUpState.value.name.isNotEmpty()
        isPassword = _signUpState.value.password.isNotEmpty()

        when {
            isNamed && isEmail && isPassword -> {
                validatedPassword = isValidPassword(_signUpState.value.password)
                if (validatedPassword) {
                    viewModelScope.launch {
                        //getSignUpUseCase.register(
                            _signUpState.value.copy(
                                id = UUID.randomUUID().toString(),
                                password = (_signUpState.value.email.plus(_signUpState.value.password)),
                                isLogged = true
                            ).toUserModel()
                        //)
                    }
                }
            }
        }
    }
}