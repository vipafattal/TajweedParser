package com.brilliancesoft.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Edition(
    val identifier: String,
    val language: String,
    val name: String,
    val englishName: String,
    val format: String,
    val type: String
)


