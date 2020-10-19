package com.brilliancesoft.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brilliancesoft.example.model.Aya
import com.brilliancesoft.tajweedparser.TajweedHelper

class RecyclerViewAdapter(private val surahAyaList: List<Aya>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ItemHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_holder, viewGroup, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(itemHolder: ItemHolder, index: Int) {
        val aya = surahAyaList[index]
        itemHolder.bind(aya)
    }

    override fun getItemCount(): Int = surahAyaList.size

    class ItemHolder(holderView: View) : RecyclerView.ViewHolder(holderView) {

        val ayaTextView: TextView = holderView.findViewById(R.id.ayahText)
        val ayaNumberTextView: TextView = holderView.findViewById(R.id.ayahNumber)

        fun bind(aya: Aya) {
            //Apply text style on aya text.
            ayaTextView.text = TajweedHelper.getStyledAyah(aya.text)
            ayaNumberTextView.text = aya.numberInSurah.toString()
        }
    }
}