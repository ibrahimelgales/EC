package com.easycashwallet.tasks.ec.config

import android.app.Application
import android.widget.Toast
import com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value.SecureKeyValueLocalStorage
import com.easycashwallet.tasks.data.di.DataModule
import com.easycashwallet.tasks.domain.di.DomainModule
import com.easycashwallet.tasks.utils.SecurityUtils
import com.easycashwallet.tasks.utils.extention.FirebaseRealTimePaths
import com.easycashwallet.tasks.utils.extention.getFirebaseRealTimeDataBaseFromPath
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
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

        getValuesFromDB()
    }

    private fun getValuesFromDB() {
        val secureKeyValueLocalStorage by inject<SecureKeyValueLocalStorage>()
        getFirebaseRealTimeDataBaseFromPath(FirebaseRealTimePaths.BASE_URL, onResult = { baseURL ->
            getFirebaseRealTimeDataBaseFromPath(
                FirebaseRealTimePaths.AUTH_TOKEN,
                onResult = { token ->
                    baseURL?.let { secureKeyValueLocalStorage.setBaseUrl(it) }
                    token?.let { secureKeyValueLocalStorage.setAuthToken(it) }
                })
        })
    }
}