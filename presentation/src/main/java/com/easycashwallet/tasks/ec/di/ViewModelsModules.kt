package com.easycashwallet.tasks.ec.di

import com.easycashwallet.tasks.ec.competition_teams.di.viewModelCompetitionTeamsModule
import com.easycashwallet.tasks.ec.competitions.di.viewModelCompetitionsModule
import com.easycashwallet.tasks.utils.extention.lazyModule

val ViewModelsModule by lazyModule {
    includes(viewModelCompetitionsModule, viewModelCompetitionTeamsModule)
}

