package com.example.testandroid.currencyscreen

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.dto.Currency
import com.example.testandroid.R
import com.example.testandroid.storage.room.CurrencyEntity

class CurrencyAdapter(val oneClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CurrencyViewHolder>() {

    private val currencyList: MutableList<CurrencyEntity> = mutableListOf()

    fun setItems(newCurrencyList: List<CurrencyEntity>) {
        currencyList.clear()
        currencyList.addAll(newCurrencyList)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(currency: CurrencyEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.currency_view_holder, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.onBind(currencyList[position], oneClickListener)
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }
}