package com.easycashwallet.tasks.data.competitions.data_source.local.preference.competitions

import com.easycashwallet.tasks.data.competitions.dto.CompetitionTeamsDTO
import com.easycashwallet.tasks.data.competitions.dto.CompetitionsDTO


interface CompetitionsLocalStorage {

    fun getCompetitions(): CompetitionsDTO?
    fun setCompetitions(dto: CompetitionsDTO)


    fun getTeamsByCompetitionId(competitionId:String): CompetitionTeamsDTO?
    fun setTeamsByCompetitionId(competitionId:String,dto: CompetitionTeamsDTO)
}