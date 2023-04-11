package com.example.imdbapp

import android.annotation.SuppressLint
import androidx.annotation.StringRes

@SuppressLint("SupportAnnotationUsage")
data class ProfileListHelper(
    val title: Int,
    val subtitle: Int,
    val quantity: Int
)

val ProfileListItems = listOf(
    ProfileListHelper(
        title = R.string.titulo_1,
        subtitle = R.string.subtitulo_1,
        quantity = R.string.numero_1
    ),
    ProfileListHelper(
        title = R.string.titulo_2,
        subtitle = R.string.subtitulo_2,
        quantity = R.string.numero_2
    ),
    ProfileListHelper(
        title = R.string.titulo_3,
        subtitle = R.string.subtitulo_3,
        quantity = R.string.numero_3
    )
)
