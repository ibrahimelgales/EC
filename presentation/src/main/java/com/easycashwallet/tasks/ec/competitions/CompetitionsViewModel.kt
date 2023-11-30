package com.easycashwallet.tasks.ec.competitions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.easycashwallet.tasks.domain.competitions.use_cases.GetCompetitionsUseCase
import com.easycashwallet.tasks.ec.competitions.mapper.CompetitionsMapperUI
import com.easycashwallet.tasks.ec.competitions.model.CompetitionsModel
import com.easycashwallet.tasks.utils.base_views.BaseViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class CompetitionsViewModel(
    private val getCompetitionsUseCase: GetCompetitionsUseCase,
    private val competitionsMapperUI: CompetitionsMapperUI
) :
    BaseViewModel() {

    //region vars
    private val _competitions = MutableLiveData<List<CompetitionsModel>>()
    val competitions: LiveData<List<CompetitionsModel>> get() = _competitions
    //endregion


    //region APIs
    fun getCompetitions() = launchViewModelScope {
        appLoader.hookThisFlow(getCompetitionsUseCase())
            .flowOn(mainDispatchers)
            .collect {
                _competitions.value = competitionsMapperUI.mapToSecond(it)
            }
    }
    //endregion
}