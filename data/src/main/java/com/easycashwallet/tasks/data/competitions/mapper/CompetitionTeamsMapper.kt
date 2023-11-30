package com.easycashwallet.tasks.data.competitions.mapper

import com.easycashwallet.tasks.data.competitions.dto.CompetitionTeamsDTO
import com.easycashwallet.tasks.domain.competitions.entities.CompetitionTeamsEntity
import com.easycashwallet.tasks.utils.Mapper


class CompetitionTeamsMapper : Mapper<CompetitionTeamsDTO, List<CompetitionTeamsEntity>> {
    override fun mapToFirst(model: List<CompetitionTeamsEntity>) = null

    override fun mapToSecond(model: CompetitionTeamsDTO?) =
        model?.teams?.let { list ->
            list.map {
                CompetitionTeamsEntity(
                    it.crest,
                    it.name,
                    it.website,
                    it.area?.name,
                    it.venue,
                    it.coach?.name,
                )
            }
        } ?: emptyList()


}