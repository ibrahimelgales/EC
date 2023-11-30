package com.easycashwallet.tasks.domain

import com.easycashwallet.tasks.domain.competitions.entities.CompetitionsEntity
import com.easycashwallet.tasks.domain.competitions.repository.CompetitionsRepository
import com.easycashwallet.tasks.domain.competitions.use_cases.GetCompetitionsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever


class GetCompetitionsUseCaseTest {

    // Mock dependencies
    private val competitionsRepository: CompetitionsRepository = mock()

    // Create an instance of the use case with the mocked repository
    private val getCompetitionsUseCase = GetCompetitionsUseCase(competitionsRepository)

    @Test
    fun `invoke should call getCompetitions on repository`(): Unit = runBlocking {

        // Assume that you have a result to return from the repository
        val expectedResult: Flow<List<CompetitionsEntity>> = mock()
        whenever(competitionsRepository.getCompetitions())
            .thenReturn(expectedResult)

        // Act
        val result = getCompetitionsUseCase()

        // Assert
        assertEquals(expectedResult, result)

        // Verify that getCompetitions on the repository was called
        verify(competitionsRepository).getCompetitions()
    }
}