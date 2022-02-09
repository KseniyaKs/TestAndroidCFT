package com.example.testandroid.storage.network

import com.example.testandroid.dto.CurrencyMap
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/daily_json.js")
    fun getCurrencyList () : Call <CurrencyMap>
}