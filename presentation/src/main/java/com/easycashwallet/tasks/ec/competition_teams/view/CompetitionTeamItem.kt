package com.easycashwallet.tasks.ec.competition_teams.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.easycashwallet.tasks.ec.competition_teams.model.CompetitionTeamsModel
import com.easycashwallet.tasks.utils.ui.LoadImage

@Composable
fun CompetitionTeamItem(
    item: CompetitionTeamsModel,
    onItemClick: (CompetitionTeamsModel) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable { onItemClick(item) }
        ) {
            LoadImage(item.teamLogo)
            NormalText(item.teamName)
            NormalText(item.countryName)
            NormalText(item.teamWebsite)
            NormalText(item.coachName)
            NormalText(item.homeStadium)
        }
    }

}

@Composable
private fun ColumnScope.NormalText(string: String) {
    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = string,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally),
        color = Color.Blue,
    )
}

