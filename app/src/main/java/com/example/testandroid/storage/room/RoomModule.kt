package com.example.testandroid.storage.room

import android.content.Context
import androidx.room.Room

object RoomModule {

    lateinit var appdataBase : AppDataBase

    fun init(context: Context) {
        appdataBase = Room.databaseBuilder(context, AppDataBase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

//    fun provide(context: Context): AppDataBase {
//        return Room.databaseBuilder(context, AppDataBase::class.java, "database")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//    }
}