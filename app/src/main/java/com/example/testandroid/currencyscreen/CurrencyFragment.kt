package com.example.testandroid.currencyscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.dto.Currency
import com.example.testandroid.R
import com.example.testandroid.storage.network.Repository
import com.example.testandroid.storage.network.RetrofitModule
import com.example.testandroid.convertationscreen.ConvertationFragment
import com.example.testandroid.storage.room.CurrencyEntity
import com.example.testandroid.storage.room.RoomModule


class CurrencyFragment : Fragment() {

    private val adapter =
        CurrencyAdapter(oneClickListener = object : CurrencyAdapter.OnItemClickListener {
            override fun onItemClick(currency: CurrencyEntity) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.currencyContainer,
                        ConvertationFragment.newInstance(currency),
                        "ConvertationFragment"
                    )
                    .addToBackStack("CONVERT_FR")
                    .commit()
            }
        })

    private val model: CurrencyViewModel by lazy {
        CurrencyViewModel(
            Repository(
                RetrofitModule.provideApi(RetrofitModule.provideRetrofit()),
                RoomModule.appdataBase.currencyDao()
            ),
            RoomModule.appdataBase
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("JC", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("JC", "onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("JC", "onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.d("JC", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("JC", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("JC", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("JC", "onStop")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rclView = view.findViewById<RecyclerView>(R.id.recyclerView)

        rclView.addItemDecoration(
            DividerItemDecoration(
                rclView.context,
                DividerItemDecoration.VERTICAL
            )
        )

        model.data.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
            Log.d("yui", it.toString())
        })

        rclView?.layoutManager = LinearLayoutManager(requireContext())
        rclView?.adapter = adapter
    }

    companion object {
        fun newInstance() = CurrencyFragment()
    }
}