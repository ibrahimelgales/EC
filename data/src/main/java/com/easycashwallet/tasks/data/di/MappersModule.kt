package com.easycashwallet.tasks.data.di

import com.easycashwallet.tasks.data.competitions.mapper.CompetitionTeamsMapper
import com.easycashwallet.tasks.data.competitions.mapper.CompetitionsMapper
import com.easycashwallet.tasks.utils.extention.lazyModule
import org.koin.dsl.module

val MapperModule by lazyModule {
    single { CompetitionsMapper() }
    single { CompetitionTeamsMapper() }
}