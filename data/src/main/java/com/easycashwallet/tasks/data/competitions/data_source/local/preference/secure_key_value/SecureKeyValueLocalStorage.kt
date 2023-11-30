package com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value


interface SecureKeyValueLocalStorage {
    fun getBaseUrl(): String
    fun setBaseUrl(value: String)
    fun getAuthToken(): String
    fun setAuthToken(value: String)
}