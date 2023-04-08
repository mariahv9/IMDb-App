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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.Medium
import com.example.imdbapp.ui.components.SignUp
import com.example.imdbapp.ui.components.SocialNetwork
import com.example.imdbapp.ui.components.button.ButtonLogin
import com.example.imdbapp.ui.components.field.EmailField
import com.example.imdbapp.ui.components.field.PasswordField
import com.example.imdbapp.ui.components.text.Bold
import com.example.imdbapp.ui.components.text.LightItalic
import com.example.imdbapp.ui.components.text.Regular
import com.example.imdbapp.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onNavigateSignUp: () -> Unit,
    onNavigateSearch: () -> Unit,
    viewModel: LoginViewModel
) {
    var emailState by rememberSaveable { mutableStateOf("") }
    var passwordState by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

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
            EmailField(
                email = emailState,
                onTextFieldChanged = { emailState = it },
                outline = colorResource(
                    id = R.color.white
                )
            )
            if (!viewModel.isUserName) {
                Regular(
                    modifier = Modifier,
                    color = colorResource(R.color.light_gray_2),
                    text = stringResource(
                        id = R.string.required,
                        stringResource(id = R.string.correo)
                    ),
                    textUnit = 10.sp
                )
            }
            Medium(
                modifier = Modifier.padding(top = 15.dp, bottom = 8.dp),
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.contraseña),
                textUnit = 20.sp
            )
            PasswordField(
                password = passwordState,
                onTextFieldChanged = { passwordState = it },
                onClick = { passwordVisibility = !passwordVisibility },
                passVisibility = passwordVisibility,
                painter = icon,
                outline = colorResource(id = R.color.white)
            )
            if (!viewModel.isPassword) {
                Regular(
                    modifier = Modifier,
                    color = colorResource(R.color.light_gray_2),
                    text = stringResource(
                        id = R.string.required,
                        stringResource(id = R.string.contraseña)
                    ),
                    textUnit = 10.sp
                )
            }
            LightItalic(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { },
                color = colorResource(id = R.color.dark_text),
                text = stringResource(id = R.string.olvidar),
                textUnit = 16.sp
            )
            ButtonLogin(onNavigate = {
                viewModel.signIn(
                    onNavigateSearch,
                    emailState,
                    passwordState
                )
            }, loginEnable = true)
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
