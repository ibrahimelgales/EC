package com.easycashwallet.tasks.ec.config

import android.app.Application
import android.widget.Toast
import com.easycashwallet.tasks.data.di.DataModule
import com.easycashwallet.tasks.domain.di.DomainModule
import com.easycashwallet.tasks.utils.SecurityUtils
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (SecurityUtils.isEmulator() || SecurityUtils.isRooted()) {
            Toast.makeText(
                this,
                com.easycashwallet.tasks.utils.R.string.rooted_device_alert,
                Toast.LENGTH_SHORT
            ).show()
            throw Exception()
        }

        startKoin {
            androidContext(this@MyApp)
            koin.loadModules(
                listOf(
                    DataModule,
                    DomainModule,
                    PresentationModule,
                )
            )
        }
    }
}