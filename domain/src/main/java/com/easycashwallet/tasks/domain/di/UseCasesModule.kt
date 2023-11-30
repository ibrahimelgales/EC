package com.easycashwallet.tasks.domain.di

import com.easycashwallet.tasks.domain.competitions.use_cases.GetCompetitionTeamsUseCase
import com.easycashwallet.tasks.domain.competitions.use_cases.GetCompetitionsUseCase
import com.easycashwallet.tasks.utils.extention.lazyModule

val UseCasesModule by lazyModule {
    includes(useCasesCaseCompetitionsModule)
}

private val useCasesCaseCompetitionsModule by lazyModule {
    single { GetCompetitionsUseCase(get()) }
    single { GetCompetitionTeamsUseCase(get()) }
}