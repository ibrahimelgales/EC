package com.easycashwallet.tasks.data.di

import com.easycashwallet.tasks.data.competitions.data_source.service.CompetitionsService
import com.easycashwallet.tasks.utils.extention.lazyModule
import org.koin.dsl.module

val ServicesModule by lazyModule {
    includes(serviceCompetitionsModule)
}

private val serviceCompetitionsModule by lazyModule {
    single { CompetitionsService.createCompetitionsService(retrofit = get()) }
}