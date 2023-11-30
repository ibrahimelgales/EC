package com.easycashwallet.tasks.data.competitions.repository

import com.easycashwallet.tasks.data.competitions.data_source.local.preference.competitions.CompetitionsLocalStorage
import com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value.SecureKeyValueLocalStorage
import com.easycashwallet.tasks.data.competitions.data_source.service.CompetitionsService
import com.easycashwallet.tasks.data.competitions.mapper.CompetitionTeamsMapper
import com.easycashwallet.tasks.data.competitions.mapper.CompetitionsMapper
import com.easycashwallet.tasks.domain.competitions.repository.CompetitionsRepository
import com.easycashwallet.tasks.utils.exception_handler.CustomExceptionManager
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CompetitionsRepositoryImp(
    private val competitionsService: CompetitionsService,
    private val customExceptionManager: CustomExceptionManager,
    private val competitionsMapper: CompetitionsMapper,
    private val competitionTeamsMapper: CompetitionTeamsMapper,
    private val competitionsLocalStorage: CompetitionsLocalStorage,
    private val secureKeyValueLocalStorage: SecureKeyValueLocalStorage,
) : CompetitionsRepository {

    override suspend fun getCompetitions() =
        customExceptionManager.parseApiException(
            flow {
                emit(
                    competitionsService.getCompetitions(
                        "${secureKeyValueLocalStorage.getBaseUrl()}competitions",
                        secureKeyValueLocalStorage.getAuthToken()
                    )
                )
            }
        ).map { response ->
            competitionsLocalStorage.setCompetitions(response)
            competitionsMapper.mapToSecond(response)
        }.catch {
            val cachedData = competitionsLocalStorage.getCompetitions()
            emit(competitionsMapper.mapToSecond(cachedData))
            if (cachedData == null)
                throw it
        }


    override suspend fun getCompetitionTeams(competitionId: String) =
        customExceptionManager.parseApiException(
            flow {
                emit(
                    competitionsService.getTeamsByCompetitionId(
                        "${secureKeyValueLocalStorage.getBaseUrl()}competitions/$competitionId/teams",
                        secureKeyValueLocalStorage.getAuthToken()
                    )
                )
            }
        ).map { response ->
            competitionsLocalStorage.setTeamsByCompetitionId(competitionId, response)
            competitionTeamsMapper.mapToSecond(response)
        }.catch {
            val cachedData = competitionsLocalStorage.getTeamsByCompetitionId(competitionId)
            emit(competitionTeamsMapper.mapToSecond(cachedData))
            if (cachedData == null)
                throw it
        }
}
