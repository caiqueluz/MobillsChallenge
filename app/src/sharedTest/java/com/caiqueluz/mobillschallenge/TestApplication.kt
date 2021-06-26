package com.caiqueluz.mobillschallenge

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {
        stopKoin()

        startKoin {
            androidContext(this@TestApplication)
            modules(listOf())
        }
    }
}

fun injectModule(builder: Module.() -> Unit) {
    val module = module(
        createdAtStart = true, moduleDeclaration = builder
    )

    loadKoinModules(module)
}
