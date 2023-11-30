package com.easycashwallet.tasks.ec.competition_teams

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.easycashwallet.tasks.ec.competition_teams.model.CompetitionTeamsModel
import com.easycashwallet.tasks.ec.competition_teams.view.CompetitionTeamsList
import com.easycashwallet.tasks.ec.ui.theme.ECTheme
import com.easycashwallet.tasks.utils.base_views.BaseComponentActivity
import org.koin.android.ext.android.inject

class CompetitionDetailActivity : BaseComponentActivity<CompetitionTeamsViewModel>() {

    //region vars
    companion object {
        private const val KEY_COMPETITION_ID = "KEY_COMPETITION_ID"
        fun createIntent(context: Context, competitionId: String) =
            Intent(context, CompetitionDetailActivity::class.java).apply {
                putExtra(KEY_COMPETITION_ID, competitionId)
            }
    }

    override val viewModel by inject<CompetitionTeamsViewModel>()
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Loading()
                    CheckDebuggingMode()
                    val competitionTeams by viewModel.competitionTeams.observeAsState()
                    CompetitionTeamsList(
                        list = competitionTeams ?: emptyList(),
                        onItemClick = {},
                        onBackPressedDispatcher
                    )
                }
            }
        }
    }

    override fun saveToCallAPIs() {
        getCompetitionId()?.let { viewModel.getCompetitionTeams(it) }
    }

    //region functions
    private fun getCompetitionId() = intent.getStringExtra(KEY_COMPETITION_ID)
    //endregion
}


@Preview(showBackground = true)
@Composable
fun ECPreview() {
    ECTheme {
        val model = CompetitionTeamsModel(
            "",
            "Arsenal",
            "www.arsenal.com",
            "England",
            "emirates stadium",
            "mikel arteta"
        )
        CompetitionTeamsList(
            list = listOf(model, model, model),
            onItemClick = {},
            onBackPressedDispatcher = null
        )
    }
}