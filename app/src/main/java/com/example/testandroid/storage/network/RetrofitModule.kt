package com.example.testandroid.storage.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitModule {

//    @Provides
//    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.cbr-xml-daily.ru")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

//    @Singleton
//    @Provides
    fun provideApi(retrofit: Retrofit) : APIService {
        return retrofit.create((APIService::class.java))
    }
}