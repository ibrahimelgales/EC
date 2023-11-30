package com.easycashwallet.tasks.ec.di

import com.easycashwallet.tasks.utils.exception_handler.CustomExceptionManager
import com.easycashwallet.tasks.utils.extention.lazyModule

val ManagersModule by lazyModule {
    single { CustomExceptionManager() }
}