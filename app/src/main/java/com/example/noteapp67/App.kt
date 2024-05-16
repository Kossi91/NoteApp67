package com.example.noteapp67

import android.app.Application
import com.example.noteapp67.utils.PreferenceHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences =PreferenceHelper()
        sharedPreferences.unit(this)
    }
}