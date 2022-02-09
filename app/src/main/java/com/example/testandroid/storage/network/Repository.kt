package com.example.testandroid.storage.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testandroid.dto.CurrencyMap
import com.example.testandroid.storage.room.CurrencyDao
import com.example.testandroid.storage.room.CurrencyMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val service: APIService, val currencyDao: CurrencyDao) {

    fun callCurrencyList() {
        service.getCurrencyList()
            .enqueue(object : Callback<CurrencyMap> {
                override fun onResponse(
                    call: Call<CurrencyMap>,
                    response: Response<CurrencyMap>
                ) {
                    response.body().let {
//                        liveData.value = it
                        it?.let { currencyMap ->
                            val currencyEntityList =
                                CurrencyMapper.mapFromCurrencyListToCurrencyEntityList(currencyMap.map.values.toList())
                            currencyDao.insertAll(currencyEntityList)
                            Log.d("retrofit", currencyEntityList.toString())
                        }
//                        Log.d("retrofit", currencyEntityList.toString())
                    }
                }

                override fun onFailure(call: Call<CurrencyMap>, t: Throwable) {
                    Log.d("retrofit", "call failed")
                }
            })
    }
}