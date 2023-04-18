package com.example.imdbapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                val bottomList = listOf(
                    stringResource(id = R.string.cines),
                    stringResource(id = R.string.estaciones),
                    stringResource(id = R.string.notificaciones),
                    stringResource(id = R.string.mejorar)
                )

                val titleList = listOf(
                    stringResource(id = R.string.titulo_1),
                    stringResource(id = R.string.titulo_2),
                    stringResource(id = R.string.titulo_3),
                )

                val subtitleList = listOf(
                    stringResource(id = R.string.subtitulo_1),
                    stringResource(id = R.string.subtitulo_2),
                    stringResource(id = R.string.subtitulo_3),
                )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .padding(bottom = 10.dp)
                        .background(colorResource(id = R.color.white))
                ) {
                    HeaderProfile(Modifier.align(Alignment.TopStart), loginViewModel)
                    LineDivider(
                        Modifier.padding(top = 65.dp, start = 35.dp, end = 35.dp),
                        colorResource(id = R.color.black_op)
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 80.dp, end = 15.dp),
                        state = rememberLazyListState()
                    ) {
                        itemsIndexed(titleList) { item, title ->
                            CardRecyclerListProfile(title, subtitleList[item])
                        }
                    }
                }

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
                bottomList.map {
                    CardListProfile(titleText = it)
                }
                Spacer(modifier = Modifier.padding(top = 70.dp))
            }
        }
    }
}
