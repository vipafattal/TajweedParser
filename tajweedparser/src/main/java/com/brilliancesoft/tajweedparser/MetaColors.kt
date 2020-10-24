package com.brilliancesoft.tajweedparser


data class MetaColors(
    val defaultColor: String = "#000000",

    //hamza-wasl, silent, laam-shamsiyah
    val hsl: String = defaultColor,

    //Normal Prolongation: 2 Vowels
    val madda_normal: String = "#537FFF",

    //Permissible Prolongation: 2, 4, 6 Vowels
    val madda_permissible: String = "#4050FF",

    //Necessary Prolongation: 6 Vowels
    val madda_necesssary: String = "#000EBC",

    //Obligatory Prolongation: 4-5 Vowels
    val madda_obligatory: String = "#2144C1",

    //Qalaqah
    val qalaqah: String = "#DD0008",

    //Ikhafa' Shafawi - With Meem
    val ikhafa_shafawi: String = "#D500B7",

    //Ikhafa'
    val ikhafa: String = "#9400A8",

    //Idgham Shafawi - With Meem
    val idgham_shafawi: String = "#58B800",

    //Iqlab
    val iqlab: String = "#26BFFD",

    //Idgham - With Ghunnah
    val idgham_with_ghunnah: String = "#169777",

    //Idgham - Without Ghunnah
    val idgham_without_ghunnah: String = "#169200",

    //Idgham - Mutajanisayn, Idgham - Mutaqaribayn
    val idgham_mutajanisayn: String = "#A1A1A1",

    //Ghunnah: 2 Vowels
    val ghunnah: String = "#FF7E1E",
) {
    companion object {

        fun default(defaultColor: String = "#000000") = MetaColors().copy(
            defaultColor = defaultColor,
            hsl = defaultColor,
            madda_normal = defaultColor,
            madda_permissible = defaultColor,
            madda_necesssary = defaultColor,
            madda_obligatory = defaultColor,
            qalaqah = defaultColor,
            ikhafa_shafawi = defaultColor,
            ikhafa = defaultColor,
            idgham_shafawi = defaultColor,
            iqlab = defaultColor,
            idgham_with_ghunnah = defaultColor,
            idgham_without_ghunnah = defaultColor,
            idgham_mutajanisayn = defaultColor,
            ghunnah = defaultColor
        )


        fun MetaColors.mudud(
            madda_normal: String = "#537FFF",
            madda_permissible: String = "#4050FF",
            madda_necessary: String = "#000EBC",
            madda_obligatory: String = "#2144C1",
            ghunnah: String = "#FF7E1E"
        ) = copy(
            madda_normal = madda_normal,
            madda_permissible = madda_permissible,
            madda_necesssary = madda_necessary,
            madda_obligatory = madda_obligatory,
            ghunnah = ghunnah
        )


        fun MetaColors.noon(
            ikhafa: String = "#9400A8",
            idgham_with_ghunnah: String = "#169777",
            idgham_without_ghunnah: String = "#169200",
            iqlab: String = "#26BFFD"
        ) = copy(
            ikhafa = ikhafa,
            idgham_with_ghunnah = idgham_with_ghunnah,
            idgham_without_ghunnah = idgham_without_ghunnah,
            iqlab = iqlab
        )


        fun MetaColors.mimm(
            ikhafa_shafawi: String = "#D500B7",
            idgham_shafawi: String = "#58B800"
        ) = copy(
            ikhafa_shafawi = ikhafa_shafawi,
            idgham_shafawi = idgham_shafawi
        )


        fun MetaColors.qalaqah(
            qalaqah: String = "#DD0008"
        ) = copy(
            qalaqah = qalaqah
        )

    }
}