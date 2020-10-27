package com.brilliancesoft.tajweedparser

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan

object TajweedHelper {

    private var tajweedMetaColors = MetaColors()

    private val tajweedMetas = "hslnpmqocfwiaudbg"

    fun setTajweedMetasColor(tajweedColors: MetaColors) {
        tajweedMetaColors = tajweedColors
    }

    fun getStyledAyah(rawAyah: String): Spannable {
        val ayahSplits = getAyahSplits(rawAyah)
        return applyTajweedColors(ayahSplits)
    }

    private fun getAyahSplits(rawAyah: String): List<String> {
        val ayah = rawAyah.replace("[\\[0-9:]".toRegex(), "")
        val splits = ayah.splitWithDelimiter("(?<=[\\]\\[$tajweedMetas])|(?=[\\]\\[$tajweedMetas])")
        return splits
    }

    private fun applyTajweedColors(splits: List<String>): Spannable {

        val spannableAya = SpannableStringBuilder("")
        var metaSpilt = ""

        for (ayahSpilt in splits) {
            when {
                tajweedMetas.contains(ayahSpilt) -> metaSpilt = ayahSpilt
                metaSpilt.isNotEmpty() -> {
                    //apply span color $metaToColor(ayahSpilt.toChar())
                    val metaColor = metaToColor(metaSpilt[0])
                    spannableAya.setSpanOnAya(ayahSpilt, metaColor)
                    metaSpilt = ""
                }
                ayahSpilt == "]" -> continue
                else -> spannableAya.setSpanOnAya(ayahSpilt, tajweedMetaColors.defaultColor)
            }
        }

        return spannableAya
    }

    private fun String.splitWithDelimiter(input: CharSequence) =
            this.split(Regex("(?<=[$input])|(?=[$input])"))


    private fun metaToColor(meta: Char): String =
            tajweedMetaColors.run {
                val color: String = when (meta) {
                    'h', 'l', 's' -> hsl
                    'n' -> madda_normal
                    'p' -> madda_permissible
                    'm' -> madda_necesssary
                    'q' -> qalaqah
                    'o' -> madda_obligatory
                    'c' -> ikhafa_shafawi
                    'f' -> ikhafa
                    'w' -> idgham_shafawi
                    'i' -> iqlab
                    'a' -> idgham_with_ghunnah
                    'u' -> idgham_without_ghunnah
                    'd'-> idgham_mutajanisayn
                    'b' -> idgham_mutaqaribayn
                    'g' -> ghunnah
                    else -> throw IllegalArgumentException("Unknown meta char: $meta")
                }
                return color
            }


    private fun SpannableStringBuilder.setSpanOnAya(ayahText: String, color: String) {

        val start = this.length
        append(ayahText)
        val end = this.length

        setSpan(
                ForegroundColorSpan(Color.parseColor(color)),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
}