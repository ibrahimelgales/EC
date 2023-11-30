package com.easycashwallet.tasks.data.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.easycashwallet.tasks.utils.extention.lazyModule

val EncryptedSharedPreferencesModule by lazyModule {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    single {
        EncryptedSharedPreferences.create(
            "easycashwallet_preferences",
            masterKeyAlias,
            get(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}