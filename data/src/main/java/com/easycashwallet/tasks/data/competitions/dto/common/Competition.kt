package com.easycashwallet.tasks.data.competitions.dto.common

data class Competition(
    val area: Area?,
    val code: String?,
    val currentSeason: Season?,
    val emblem: String?,
    val id: String?,
    val lastUpdated: String?,
    val name: String?,
    val numberOfAvailableSeasons: String?,
    val plan: String?,
    val type: String?
)