package com.easycashwallet.tasks.data.competitions.data_source.local.preference.competitions

import android.content.SharedPreferences
import com.easycashwallet.tasks.data.competitions.dto.CompetitionTeamsDTO
import com.easycashwallet.tasks.data.competitions.dto.CompetitionsDTO
import com.easycashwallet.tasks.utils.extention.fromJson
import com.easycashwallet.tasks.utils.extention.json
import com.easycashwallet.tasks.utils.extention.set

class CompetitionsLocalStorageImpl(private val sharedPreferences: SharedPreferences) :
    CompetitionsLocalStorage {

    companion object {
        private const val BASE =
            "com.easycashwallet.tasks.data.competitions.data_source.local.preference.CompetitionsLocalStorageImpl_"
        private const val COMPETITIONS_LIST = "${BASE}COMPETITIONS_LIST"
        private const val COMPETITION_TEAMS_LIST = "${BASE}COMPETITION_TEAMS_LIST"
    }

    override fun getCompetitions(): CompetitionsDTO? = sharedPreferences.getString(COMPETITIONS_LIST, null).fromJson()

    override fun setCompetitions(dto: CompetitionsDTO) {
        sharedPreferences[COMPETITIONS_LIST] = dto.json()
    }

    override fun getTeamsByCompetitionId(competitionId:String): CompetitionTeamsDTO?  = sharedPreferences.getString("$COMPETITION_TEAMS_LIST$competitionId", null).fromJson()

    override fun setTeamsByCompetitionId(competitionId:String,dto: CompetitionTeamsDTO) {
        sharedPreferences["$COMPETITION_TEAMS_LIST$competitionId"] = dto.json()
    }


}