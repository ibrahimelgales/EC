package com.easycashwallet.tasks.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val builder = req.newBuilder().apply {
            addHeader("X-Requested-With", "XMLHttpRequest")
            addHeader("X-Auth-Token", "d4831e7f6d7842ebb29d7727469641f0")
        }
        req = builder.url(req.url).build()

        return chain.proceed(req)
    }


}