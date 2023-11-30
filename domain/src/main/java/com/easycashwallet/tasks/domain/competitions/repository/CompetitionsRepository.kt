package com.easycashwallet.tasks.domain.competitions.repository
import com.easycashwallet.tasks.domain.competitions.entities.CompetitionTeamsEntity
import com.easycashwallet.tasks.domain.competitions.entities.CompetitionsEntity
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {
    suspend fun getCompetitions(): Flow<List<CompetitionsEntity>>
    suspend fun getCompetitionTeams(competitionId:String): Flow<List<CompetitionTeamsEntity>>
}