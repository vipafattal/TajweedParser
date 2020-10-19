package com.brilliancesoft.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Aya (
    val number: Int,
    val text: String,
    val numberInSurah: Int,
    val juz: Int,
    val page: Int,
    val ruku: Int,
    val manzil: Int,
    val hizbQuarter: Int,
    var surah_number: Int = 0,
    var ayaEdition: String = ""
)