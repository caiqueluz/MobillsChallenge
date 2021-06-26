package com.caiqueluz.mobillschallenge

import android.app.Application
import com.caiqueluz.mobillschallenge.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MobillsChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {
        startKoin {
            androidLogger()
            androidContext(this@MobillsChallengeApplication)
            modules(appModules)
        }
    }
}
