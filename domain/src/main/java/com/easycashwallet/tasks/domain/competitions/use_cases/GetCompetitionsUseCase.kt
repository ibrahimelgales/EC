package com.easycashwallet.tasks.domain.competitions.use_cases

import com.easycashwallet.tasks.domain.competitions.repository.CompetitionsRepository


class GetCompetitionsUseCase(private val competitionsRepository: CompetitionsRepository) {
    suspend operator fun invoke() =
        competitionsRepository.getCompetitions()
}