package com.example.testandroid.currencyscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testandroid.dto.Currency
import com.example.testandroid.dto.CurrencyMap
import com.example.testandroid.storage.network.Repository
import com.example.testandroid.storage.room.AppDataBase
import com.example.testandroid.storage.room.CurrencyDao
import com.example.testandroid.storage.room.CurrencyEntity
import com.example.testandroid.storage.room.CurrencyMapper
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class CurrencyViewModel(repository: Repository, db: AppDataBase) : ViewModel() {

    var data: LiveData<List<CurrencyEntity>>

    init {
        data = db.currencyDao().getAll()
        repository.callCurrencyList()
    }

//    fun getCurrencyEntity(currencyList: List<Currency>): MutableLiveData<CurrencyMap> {
//        var dataDB: MutableLiveData<CurrencyMap> = MutableLiveData()
////        val currencyDao: CurrencyDao = db.currencyDao()
//        viewModelScope.launch {
//            val entity = currency.let {
//                CurrencyMapper.mapFromCurrencyToCurrencyEntity(it)
//            }
//            dataDB = currencyDao.insertAll(entity) as MutableLiveData<CurrencyMap>
//
//        }
//        return dataDB
//    }
}