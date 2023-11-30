package com.easycashwallet.tasks.data.competitions.data_source.service

import com.easycashwallet.tasks.data.competitions.dto.CompetitionTeamsDTO
import com.easycashwallet.tasks.data.competitions.dto.CompetitionsDTO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Url

interface CompetitionsService {
    companion object {
        fun createCompetitionsService(retrofit: Retrofit): CompetitionsService {
            return retrofit.create(CompetitionsService::class.java)
        }

    }

    @GET
    suspend fun getCompetitions(@Url url: String, @Header("X-Auth-Token") token:String): Response<CompetitionsDTO>

    @GET
    suspend fun getTeamsByCompetitionId(@Url url: String, @Header("X-Auth-Token") token:String): Response<CompetitionTeamsDTO>
}