package com.easycashwallet.tasks.ec.config

import com.easycashwallet.tasks.ec.di.ManagersModule
import com.easycashwallet.tasks.ec.di.MappersModule
import com.easycashwallet.tasks.ec.di.ViewModelsModule
import com.easycashwallet.tasks.utils.extention.lazyModule
import org.koin.dsl.module

val PresentationModule by lazyModule {
    includes(ViewModelsModule, ManagersModule, MappersModule)
}