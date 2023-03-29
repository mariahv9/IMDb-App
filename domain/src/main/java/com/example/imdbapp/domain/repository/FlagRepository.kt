package com.example.imdbapp.domain.repository

interface FlagRepository {
    fun getBooleanConfigByKey(key: String): Boolean
    fun getStringConfigByKey(key: String): String
    fun getDoubleConfigByKey(key: String): Double
    fun getLongConfigByKey(key: String): Long
}
