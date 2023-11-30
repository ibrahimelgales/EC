package com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value

import android.content.SharedPreferences
import com.easycashwallet.tasks.utils.extention.fromJson
import com.easycashwallet.tasks.utils.extention.set

class SecureKeyValueLocalStorageImpl(private val sharedPreferences: SharedPreferences) :
    SecureKeyValueLocalStorage {

    companion object {
        private const val BASE =
            "com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value.SecureKeyValueLocalStorageImpl_"
        private const val BASE_URL = "${BASE}BASE_URL"
        private const val AUTH_TOKEN = "${BASE}AUTH_TOKEN"
    }



    override fun getBaseUrl() = sharedPreferences.getString(BASE_URL, null) ?: "https://example.com/"

    override fun setBaseUrl(value: String) {
        sharedPreferences[BASE_URL] = value
    }

    override fun getAuthToken()  = sharedPreferences.getString(AUTH_TOKEN, null) ?: ""

    override fun setAuthToken(value: String) {
        sharedPreferences[AUTH_TOKEN] = value
    }


}