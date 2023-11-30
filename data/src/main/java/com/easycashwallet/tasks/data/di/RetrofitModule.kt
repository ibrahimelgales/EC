package com.easycashwallet.tasks.data.di

import com.easycashwallet.tasks.retrofit.AuthInterceptor
import com.easycashwallet.tasks.retrofit.RetroClient
import com.easycashwallet.tasks.utils.extention.lazyModule

val RetrofitModule by lazyModule {
    single { AuthInterceptor() }
    single { RetroClient.provideOkHttpClient(get()) }
    single { RetroClient.provideRetrofit(get(),) }
}