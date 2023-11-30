package com.easycashwallet.tasks.ec.competition_teams.di

import com.easycashwallet.tasks.ec.competition_teams.mapper.CompetitionTeamsMapperUI
import com.easycashwallet.tasks.utils.extention.lazyModule

val mapperCompetitionDetailModule by lazyModule {
    single { CompetitionTeamsMapperUI() }
}