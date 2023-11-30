package com.easycashwallet.tasks.ec.di

import com.easycashwallet.tasks.ec.competition_teams.di.mapperCompetitionDetailModule
import com.easycashwallet.tasks.ec.competitions.di.mapperCompetitionsModule
import com.easycashwallet.tasks.utils.extention.lazyModule


val MappersModule by lazyModule {
    includes(mapperCompetitionsModule, mapperCompetitionDetailModule)
}