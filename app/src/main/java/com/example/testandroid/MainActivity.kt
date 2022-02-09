package com.example.testandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testandroid.currencyscreen.CurrencyFragment
import com.example.testandroid.storage.room.RoomModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomModule.init(this)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.currencyContainer, CurrencyFragment.newInstance())
                .commit()
        }
    }
}