package com.easycashwallet.tasks.ec.competition_teams.view

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.easycashwallet.tasks.ec.competition_teams.model.CompetitionTeamsModel

@Composable
fun CompetitionTeamsList(
    list: List<CompetitionTeamsModel>,
    onItemClick: (CompetitionTeamsModel) -> Unit,
    onBackPressedDispatcher: OnBackPressedDispatcher?
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.clickable {
                    onBackPressedDispatcher?.onBackPressed()
                })

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Competition Teams List", style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        LazyColumn {
            items(list) { item ->
                CompetitionTeamItem(item, onItemClick)
            }
        }

    }
}

