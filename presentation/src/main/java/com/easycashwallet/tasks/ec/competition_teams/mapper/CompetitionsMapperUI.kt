package com.easycashwallet.tasks.ec.competition_teams.mapper

import com.easycashwallet.tasks.domain.competitions.entities.CompetitionTeamsEntity
import com.easycashwallet.tasks.ec.competition_teams.model.CompetitionTeamsModel
import com.easycashwallet.tasks.utils.Mapper


class CompetitionTeamsMapperUI : Mapper<List<CompetitionTeamsEntity>, List<CompetitionTeamsModel>> {

    override fun mapToFirst(model: List<CompetitionTeamsModel>): List<CompetitionTeamsEntity>? =
        null

    override fun mapToSecond(model: List<CompetitionTeamsEntity>?) = model?.let {
        it.map { item ->
            CompetitionTeamsModel(
                item.teamLogo.orEmpty(),
                item.teamName.orEmpty(),
                item.teamWebsite.orEmpty(),
                item.countryName.orEmpty(),
                item.homeStadium.orEmpty(),
                item.coachName.orEmpty(),
            )
        }
    } ?: emptyList()

}