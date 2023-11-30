package com.easycashwallet.tasks.data.competitions.dto

import com.easycashwallet.tasks.data.competitions.dto.common.Competition
import com.easycashwallet.tasks.data.competitions.dto.common.Filters

data class CompetitionsDTO(
    val competitions: List<Competition>?,
    val count: String?,
    val filters: Filters?
)


