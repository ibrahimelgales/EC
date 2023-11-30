package com.easycashwallet.tasks.data.competitions.mapper

import com.easycashwallet.tasks.data.competitions.dto.CompetitionsDTO
import com.easycashwallet.tasks.domain.competitions.entities.CompetitionsEntity
import com.easycashwallet.tasks.utils.Mapper


class CompetitionsMapper : Mapper<CompetitionsDTO, List<CompetitionsEntity>> {


    override fun mapToFirst(model: List<CompetitionsEntity>) = null

    override fun mapToSecond(model: CompetitionsDTO?) =
        model?.competitions?.let { competitionsList ->
            competitionsList.map {
                CompetitionsEntity(
                    it.id,
                    it.name,
                    it.area?.name,
                    it.emblem,
                    it.type,
                    it.currentSeason?.startDate,
                    it.currentSeason?.endDate,
                    it.lastUpdated,

                )
            }
        } ?: emptyList()

}