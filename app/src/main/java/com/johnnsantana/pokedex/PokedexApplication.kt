package com.johnnsantana.pokedex

import android.app.Application
import com.johnnsantana.pokedex.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PokedexApplication)
            modules(appModule)

        }
    }
}