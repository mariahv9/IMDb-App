package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.imdbapp.R
import com.example.imdbapp.ui.components.*
import com.example.imdbapp.viewmodel.LoginViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(loginViewModel: LoginViewModel, navController: NavController) {
    Scaffold(
        bottomBar = { CustomBottomBar(navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.light_gray))
        ) {
            ProfilePage(modifier = Modifier.align(Alignment.TopStart), loginViewModel)
        }
    }
}

@Composable
fun ProfilePage(modifier: Modifier, loginViewModel: LoginViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CardProfileHeader(loginViewModel)

        // Lista seguimiento
        CardSectionProfile(
            title = stringResource(id = R.string.lista_seguimiento),
            description = stringResource(id = R.string.text1),
            boolean = true,
            button = stringResource(id = R.string.empieza_lista)
        )

        // Vistas recientes
        CardSectionProfile(
            title = stringResource(id = R.string.vistas_recientes),
            description = stringResource(id = R.string.text2),
            boolean = false
        )

        // Personas favoritas
        CardSectionProfile(
            title = stringResource(id = R.string.personas_fav),
            description = stringResource(id = R.string.text3),
            boolean = true,
            button = stringResource(id = R.string.agg_personas)
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        CardListProfile(title = stringResource(id = R.string.cines))
        CardListProfile(title = stringResource(id = R.string.estaciones))
        CardListProfile(title = stringResource(id = R.string.notificaciones))
        CardListProfile(title = stringResource(id = R.string.mejorar))
        Spacer(modifier = Modifier.padding(top = 70.dp))
    }
}
