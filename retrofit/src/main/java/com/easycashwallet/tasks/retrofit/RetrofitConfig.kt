package com.easycashwallet.tasks.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetroClient {

    //region var
    private const val READ_TIME_OUT_CONNECTION = 30
    private const val WRITE_TIME_OUT_CONNECTION = 30
    private const val TIME_OUT_CONNECTION = 30
    private val timeUnit = TimeUnit.SECONDS
    //endregion

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://example.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
            .readTimeout(
                READ_TIME_OUT_CONNECTION.toLong(),
                timeUnit
            )
            .writeTimeout(
                WRITE_TIME_OUT_CONNECTION.toLong(),
                timeUnit
            )
            .connectTimeout(
                TIME_OUT_CONNECTION.toLong(),
                timeUnit
            )

            .addInterceptor(authInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.NONE
            }).build()
    }
}