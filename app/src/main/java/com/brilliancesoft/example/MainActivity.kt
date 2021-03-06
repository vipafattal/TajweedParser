package com.brilliancesoft.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.brilliancesoft.example.model.QuranCloudModels
import com.brilliancesoft.tajweedparser.MetaColors
import com.brilliancesoft.tajweedparser.MetaColors.Companion.mudud
import com.brilliancesoft.tajweedparser.TajweedHelper

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Parsing assets file "quran_tajweed.json" using local json parser using Kotlin serialization.
        val data =
            LocalJsonParser(this).parse("quran_tajweed.json", QuranCloudModels.Quran.serializer())

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //Optional: applying custom tajweed colors.
        val metaColors = MetaColors(hsl = "#FF6200EE", ikhafa = "#D50000")
        TajweedHelper.setTajweedMetasColor(metaColors)

        //Binding Surah number 1 which is Al-Baqraa, to vertical RecyclerView.
        recyclerView.adapter = RecyclerViewAdapter(data.data.surahs[23].ayahs)
    }
}