package com.easycashwallet.tasks.data.competitions.dto

import com.easycashwallet.tasks.data.competitions.dto.common.Competition
import com.easycashwallet.tasks.data.competitions.dto.common.Filters
import com.easycashwallet.tasks.data.competitions.dto.common.Season
import com.easycashwallet.tasks.data.competitions.dto.common.Team

data class CompetitionTeamsDTO(
    val competition: Competition,
    val season: Season,
    val teams: List<Team>,
    val count: String?,
    val filters: Filters?
)








