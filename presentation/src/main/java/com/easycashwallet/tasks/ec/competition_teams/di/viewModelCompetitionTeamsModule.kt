package com.easycashwallet.tasks.ec.competition_teams.di

import com.easycashwallet.tasks.ec.competition_teams.CompetitionTeamsViewModel
import com.easycashwallet.tasks.ec.competitions.CompetitionsViewModel
import com.easycashwallet.tasks.utils.extention.lazyModule
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelCompetitionTeamsModule by lazyModule {
    viewModel { CompetitionTeamsViewModel(get(), get()) }
}