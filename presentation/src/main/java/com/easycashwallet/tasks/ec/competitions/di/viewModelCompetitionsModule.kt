package com.easycashwallet.tasks.ec.competitions.di

import com.easycashwallet.tasks.ec.competitions.CompetitionsViewModel
import com.easycashwallet.tasks.utils.extention.lazyModule
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelCompetitionsModule by lazyModule {
    viewModel { CompetitionsViewModel(get(), get()) }
}