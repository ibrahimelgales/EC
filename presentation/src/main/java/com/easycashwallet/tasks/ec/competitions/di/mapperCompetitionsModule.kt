package com.easycashwallet.tasks.ec.competitions.di

import com.easycashwallet.tasks.ec.competitions.mapper.CompetitionsMapperUI
import com.easycashwallet.tasks.utils.extention.lazyModule

val mapperCompetitionsModule by lazyModule {
    single { CompetitionsMapperUI() }
}
