package com.example.imdbapp

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun String.toYear(): String =
    try {
        SimpleDateFormat("yyyy")
            .format(
                checkNotNull(
                    SimpleDateFormat("yyyy-MM-dd")
                        .parse(this)
                )
            )
    } catch (e: ParseException) {
        ""
    }
