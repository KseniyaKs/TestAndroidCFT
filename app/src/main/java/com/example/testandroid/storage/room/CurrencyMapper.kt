package com.example.testandroid.storage.room

import com.example.testandroid.dto.Currency

object CurrencyMapper {
    fun mapFromCurrencyToCurrencyEntity(currency: Currency): CurrencyEntity {
        return CurrencyEntity(
            currency.id, currency.numCode, currency.charCode,
            currency.nominal, currency.name, currency.value, currency.previosValue
        )
    }

    fun mapFromCurrencyListToCurrencyEntityList(currencyList: List<Currency>): List<CurrencyEntity> {
        val currencyEntityList = mutableListOf<CurrencyEntity>()
        for (currency in currencyList) {
            currencyEntityList.add(mapFromCurrencyToCurrencyEntity(currency))
        }
        return currencyEntityList
    }

    fun mapFromCurrencyEntityToCurrency(currencyEntity: CurrencyEntity): Currency {
        return Currency(
            currencyEntity.id,
            currencyEntity.numCode,
            currencyEntity.charCode,
            currencyEntity.nominal,
            currencyEntity.name,
            currencyEntity.value,
            currencyEntity.previosValue
        )
    }
}