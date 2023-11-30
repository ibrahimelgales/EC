package com.easycashwallet.tasks.ec.competition_teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.easycashwallet.tasks.domain.competitions.use_cases.GetCompetitionTeamsUseCase
import com.easycashwallet.tasks.ec.competition_teams.mapper.CompetitionTeamsMapperUI
import com.easycashwallet.tasks.ec.competition_teams.model.CompetitionTeamsModel
import com.easycashwallet.tasks.utils.base_views.BaseViewModel
import kotlinx.coroutines.flow.flowOn

class CompetitionTeamsViewModel(
    private val getCompetitionTeamsUseCase: GetCompetitionTeamsUseCase,
    private val competitionTeamsMapperUI: CompetitionTeamsMapperUI
) :
    BaseViewModel() {

    //region vars
    private val _competitionTeams = MutableLiveData<List<CompetitionTeamsModel>>()
    val competitionTeams: LiveData<List<CompetitionTeamsModel>> get() = _competitionTeams
    //endregion


    //region APIs
    fun getCompetitionTeams(competitionId:String) = launchViewModelScope {
        appLoader.hookThisFlow(getCompetitionTeamsUseCase(competitionId))
            .flowOn(mainDispatchers)
            .collect {
                _competitionTeams.value = competitionTeamsMapperUI.mapToSecond(it)
            }
    }
    //endregion
}