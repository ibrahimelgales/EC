package com.easycashwallet.tasks.ec.competitions.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.easycashwallet.tasks.ec.competitions.model.CompetitionsModel

@Composable
fun CompetitionsList(
    competitionList: List<CompetitionsModel>,
    onItemClick: (CompetitionsModel) -> Unit,
) {
    LazyColumn {
        items(competitionList) { competitionItem ->
            CompetitionItem(competitionItem, onItemClick)
        }
    }
}