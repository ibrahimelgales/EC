package com.easycashwallet.tasks.data.di

import com.easycashwallet.tasks.utils.extention.lazyModule

val DataModule by lazyModule {
    includes(RetrofitModule, ServicesModule, MapperModule, RepositoryModule, EncryptedSharedPreferencesModule)
}