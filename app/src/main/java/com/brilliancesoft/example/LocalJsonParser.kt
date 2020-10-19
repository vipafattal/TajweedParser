package com.brilliancesoft.example

import android.content.Context
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import java.io.IOException
import java.io.InputStream

/**
 * Created by ${User} on ${Date}
 */

class LocalJsonParser(private val context: Context) {


    fun <T> parse(assetsFilePath: String, deserializationStrategy: DeserializationStrategy<T>): T {
        val data = context.assets.open(assetsFilePath).stringify()

        return Json { ignoreUnknownKeys = true }.decodeFromString(deserializationStrategy, data)
    }

    private fun InputStream.stringify(): String {
        try {
            val bytes = ByteArray(available())
            read(bytes, 0, bytes.size)
            return String(bytes)
        } catch (e: IOException) {
            return ""
        }
    }
}