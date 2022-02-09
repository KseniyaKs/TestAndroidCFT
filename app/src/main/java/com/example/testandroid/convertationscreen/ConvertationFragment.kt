package com.example.testandroid.convertationscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.example.testandroid.dto.Currency
import com.example.testandroid.R
import com.example.testandroid.storage.room.CurrencyEntity


class ConvertationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_convertation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currency = arguments?.get(CURRENCY_KEY) as CurrencyEntity

        val txtNominal = view.findViewById<TextView>(R.id.txt_nominal)
        val edtTxtValueInRub = view.findViewById<EditText>(R.id.edt_value_in_rub)
        val txtValueInValute = view.findViewById<TextView>(R.id.txt_value_in_valute)

        var valueInRub = edtTxtValueInRub.text.toString().toFloat()

        edtTxtValueInRub.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty()) {
                txtValueInValute.text = " = ${(text.toString().toFloat() / currency.value)}"
            }
        }

        txtNominal.text = "1${currency.charCode} = ${currency.value} RUB"
        txtValueInValute.text = " = ${(valueInRub / currency.value)}"
    }

    companion object {
        private const val CURRENCY_KEY = "CURRENCY_KEY"

        fun newInstance(currency: CurrencyEntity?) = ConvertationFragment().apply {
            arguments = Bundle().apply {
                putSerializable(CURRENCY_KEY, currency)
            }
        }
    }
}