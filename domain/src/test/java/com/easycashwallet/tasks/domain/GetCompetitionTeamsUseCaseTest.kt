package com.easycashwallet.tasks.domain

import com.easycashwallet.tasks.domain.competitions.entities.CompetitionTeamsEntity
import com.easycashwallet.tasks.domain.competitions.repository.CompetitionsRepository
import com.easycashwallet.tasks.domain.competitions.use_cases.GetCompetitionTeamsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

class GetCompetitionTeamsUseCaseTest {


    // Mock dependencies
    private val competitionsRepository: CompetitionsRepository = Mockito.mock()

    // Create an instance of the use case with the mocked repository
    private val getCompetitionTeamsUseCase = GetCompetitionTeamsUseCase(competitionsRepository)


    @Test
    fun `invoke should call getCompetitionTeamsUseCase on repository`(): Unit = runBlocking {

        // Assume that you have a result to return from the repository
        val expectedResult: Flow<List<CompetitionTeamsEntity>> = Mockito.mock()
        // Given
        val competitionId = "123"

        whenever(competitionsRepository.getCompetitionTeams(competitionId))
            .thenReturn(expectedResult)


        // Act
        val result = getCompetitionTeamsUseCase(competitionId)

        // Assert
        assertEquals(expectedResult, result)

        // Verify that getCompetitionTeamsUseCase on the repository was called
        Mockito.verify(competitionsRepository).getCompetitionTeams(competitionId)
    }
}