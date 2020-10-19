package com.brilliancesoft.example.model

import kotlinx.serialization.Serializable


/**
 * Created by ${User} on ${Date}
 */
object QuranCloudModels {

    @Serializable
    data class Quran(val data: QuranData, val code: Int, val status: String)

    @Serializable
    data class QuranData(val surahs: List<QuranSurah>, val edition: Edition)

    @Serializable
    data class QuranSurah(
        val number: Int,
        val name: String,
        val englishName: String,
        val englishNameTranslation: String,
        val revelationType: String,
        val ayahs: List<Aya>
    )

    @Serializable
    data class Editions(
            var data: List<Edition>,
            val code: Int,
            val status: String
    )
}