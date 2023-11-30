package com.easycashwallet.tasks.data.di


import com.easycashwallet.tasks.data.competitions.data_source.local.preference.competitions.CompetitionsLocalStorage
import com.easycashwallet.tasks.data.competitions.data_source.local.preference.competitions.CompetitionsLocalStorageImpl
import com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value.SecureKeyValueLocalStorageImpl
import com.easycashwallet.tasks.data.competitions.repository.CompetitionsRepositoryImp
import com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value.SecureKeyValueLocalStorage
import com.easycashwallet.tasks.domain.competitions.repository.CompetitionsRepository
import com.easycashwallet.tasks.utils.extention.lazyModule


val RepositoryModule by lazyModule {
    includes(repositoryCompetitionsModule, repositoryLocalCompetitionsModule,repositoryLocalSecureKeyValueModule)
}

private val repositoryCompetitionsModule by lazyModule {
    factory<CompetitionsRepository> { CompetitionsRepositoryImp(get(), get(), get(), get(), get(),get()) }
}

private val repositoryLocalCompetitionsModule by lazyModule {
    factory<CompetitionsLocalStorage> { CompetitionsLocalStorageImpl(get()) }
}

private val repositoryLocalSecureKeyValueModule by lazyModule {
    factory<SecureKeyValueLocalStorage> { SecureKeyValueLocalStorageImpl(get()) }
}


