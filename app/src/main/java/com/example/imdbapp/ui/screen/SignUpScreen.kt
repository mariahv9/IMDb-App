package com.example.imdbapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.ArrowBack
import com.example.imdbapp.ui.components.ButtonSign
import com.example.imdbapp.ui.components.EmailSignUp
import com.example.imdbapp.ui.components.Medium
import com.example.imdbapp.ui.components.NameField
import com.example.imdbapp.ui.components.PasswordSignUp
import com.example.imdbapp.ui.components.text.LightItalic
import com.example.imdbapp.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(onBack: () -> Unit, viewModel: SignUpViewModel) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val name: String by viewModel.name.observeAsState(initial = "")
    val signEnable: Boolean by viewModel.signUpEnable.observeAsState(initial = false)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        ArrowBack { onBack() }
        Column(modifier = Modifier.padding(start = 35.dp, end = 35.dp, top = 50.dp)) {
            Image(
                modifier = Modifier.padding(),
                painter = painterResource(id = R.drawable.imdb_logo),
                contentDescription = "Logo"
            )
            Medium(
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.sign_up_title),
                textUnit = 25.sp
            )
            Medium(
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.nombre),
                textUnit = 20.sp
            )
            NameField(name) { viewModel.onNameChanged(it) }
            Medium(
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.correo),
                textUnit = 20.sp
            )
            EmailSignUp(email) { viewModel.onLoginChanged(it, password) }
            Medium(
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.contraseña),
                textUnit = 20.sp
            )
            PasswordSignUp(password) { viewModel.onLoginChanged(email, it) }
            if (!viewModel.isValidPassword(password)) {
                LightItalic(
                    modifier = Modifier.padding(top = 5.dp),
                    color = colorResource(id = R.color.dark_text),
                    text = stringResource(id = R.string.verificacion),
                    textUnit = 15.sp
                )
            }
            ButtonSign(signEnable) { }
        }
    }
}
