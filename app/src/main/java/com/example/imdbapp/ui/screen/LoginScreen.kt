package com.example.imdbapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.EmailField
import com.example.imdbapp.ui.components.Medium
import com.example.imdbapp.ui.components.SignUp
import com.example.imdbapp.ui.components.SocialNetwork
import com.example.imdbapp.ui.components.button.ButtonLogin
import com.example.imdbapp.ui.components.field.PasswordField
import com.example.imdbapp.ui.components.text.Bold
import com.example.imdbapp.ui.components.text.LightItalic
import com.example.imdbapp.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onNavigateSignUp: () -> Unit,
    onNavigateSearch: () -> Unit,
    viewModel: LoginViewModel
) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_color))
    ) {
        Column(modifier = Modifier.padding(start = 35.dp, end = 35.dp, top = 50.dp)) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.imdb_logo),
                contentDescription = "Logo"
            )
            Medium(
                modifier = Modifier.padding(top = 25.dp, bottom = 8.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.usuario),
                textUnit = 20.sp
            )
            EmailField(email) { viewModel.onLoginChanged(it, password) }
            Medium(
                modifier = Modifier.padding(top = 15.dp, bottom = 8.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.contraseña),
                textUnit = 20.sp
            )
            PasswordField(password) { viewModel.onLoginChanged(email, it) }
            LightItalic(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { },
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.olvidar),
                textUnit = 16.sp
            )
            ButtonLogin({ onNavigateSearch() }, loginEnable)
            LightItalic(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.segunda_opcion),
                textUnit = 18.sp
            )
            SocialNetwork(Modifier.align(Alignment.CenterHorizontally))
            SignUp(
                onNavigate = { onNavigateSignUp() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Bold(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { onNavigateSearch() }
                .padding(top = 25.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.invitado),
                textUnit = 18.sp)
        }
    }
}
