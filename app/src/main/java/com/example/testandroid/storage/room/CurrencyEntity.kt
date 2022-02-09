package com.example.testandroid.storage.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Entity
data class CurrencyEntity(
    val id: String,
    val numCode: String,
    val  charCode: String,
    val nominal: Int,
    @PrimaryKey
    val name: String,
    val value: Float,
    val previosValue: Float
): Serializable
//val id: String,
//@field:Json(name = "NumCode") val numCode: String,
//@field:Json(name = "CharCode") val charCode: String,
//@field:Json(name = "Nominal") val nominal: Int,
//@field:Json(name = "Name") val name: String,
//@field:Json(name = "Value") val value: Float,
//@field:Json(name = "Previous") val previosValue: Float)
