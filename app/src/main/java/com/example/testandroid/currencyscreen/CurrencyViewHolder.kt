package com.example.testandroid.currencyscreen

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.dto.Currency
import com.example.testandroid.R
import com.example.testandroid.storage.room.CurrencyEntity

class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val currencyName: TextView = itemView.findViewById(R.id.txt_currencyName)

    fun onBind(currency: CurrencyEntity, oneClickListener: CurrencyAdapter.OnItemClickListener) {
        currencyName.text = currency.name

        itemView.setOnClickListener {
            oneClickListener.onItemClick(currency)
        }
    }
}