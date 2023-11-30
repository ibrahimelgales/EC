package com.easycashwallet.tasks.domain.competitions.use_cases

import com.easycashwallet.tasks.domain.competitions.repository.CompetitionsRepository


class GetCompetitionTeamsUseCase(private val competitionsRepository: CompetitionsRepository) {
    suspend operator fun invoke(competitionId:String) =
        competitionsRepository.getCompetitionTeams(competitionId)
}