package com.lab.compose

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}