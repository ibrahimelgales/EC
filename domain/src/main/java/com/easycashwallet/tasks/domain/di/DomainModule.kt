package com.easycashwallet.tasks.domain.di

import com.easycashwallet.tasks.utils.extention.lazyModule

val DomainModule by lazyModule {
    includes(UseCasesModule)
}