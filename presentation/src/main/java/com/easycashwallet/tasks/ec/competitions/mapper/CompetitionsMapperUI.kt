package com.easycashwallet.tasks.ec.competitions.mapper

import com.easycashwallet.tasks.domain.competitions.entities.CompetitionsEntity
import com.easycashwallet.tasks.ec.competitions.model.CompetitionsModel
import com.easycashwallet.tasks.utils.Mapper


class CompetitionsMapperUI : Mapper<List<CompetitionsEntity>, List<CompetitionsModel>> {
    override fun mapToFirst(model: List<CompetitionsModel>): List<CompetitionsEntity> = emptyList()

    override fun mapToSecond(model: List<CompetitionsEntity>?) = model?.let { list ->
        list.map {
            CompetitionsModel(
                it.id,
                it.competitionName(),
                it.areaName(),
                it.competitionEmblem.orEmpty(),
            )
        }
    } ?: listOf()


    private fun CompetitionsEntity.competitionName() =
        competitionName?.let { "Name: $it" }.orEmpty()

    private fun CompetitionsEntity.areaName() = areaName?.let { "Area: $it" }.orEmpty()
}