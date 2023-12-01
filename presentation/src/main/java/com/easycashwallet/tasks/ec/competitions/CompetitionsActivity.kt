package com.easycashwallet.tasks.ec.competitions

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
import com.easycashwallet.tasks.data.competitions.data_source.local.preference.secure_key_value.SecureKeyValueLocalStorage
import com.easycashwallet.tasks.ec.competition_teams.CompetitionDetailActivity
import com.easycashwallet.tasks.ec.competitions.model.CompetitionsModel
import com.easycashwallet.tasks.ec.competitions.view.CompetitionsList
import com.easycashwallet.tasks.ec.ui.theme.ECTheme
import com.easycashwallet.tasks.utils.base_views.BaseComponentActivity
import com.easycashwallet.tasks.utils.extention.FirebaseRealTimePaths
import com.easycashwallet.tasks.utils.extention.getFirebaseRealTimeDataBaseFromPath
import org.koin.android.ext.android.inject

class CompetitionsActivity : BaseComponentActivity<CompetitionsViewModel>() {

    //region vars
    override val viewModel by inject<CompetitionsViewModel>()
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
                    val competitions by viewModel.competitions.observeAsState()
                    CompetitionsList(competitions ?: emptyList()) {
                        val id = it.id ?: return@CompetitionsList
                        startActivity(CompetitionDetailActivity.createIntent(this, id))
                    }
                }
            }
        }
    }

    override fun saveToCallAPIs() {
        getValuesFromDB {
            viewModel.getCompetitions()
        }
    }

    private fun getValuesFromDB(onLoadDB :() -> Unit) {
        val secureKeyValueLocalStorage by inject<SecureKeyValueLocalStorage>()
        getFirebaseRealTimeDataBaseFromPath(FirebaseRealTimePaths.BASE_URL, onResult = { baseURL ->
            getFirebaseRealTimeDataBaseFromPath(
                FirebaseRealTimePaths.AUTH_TOKEN,
                onResult = { token ->
                    baseURL?.let { secureKeyValueLocalStorage.setBaseUrl(it) }
                    token?.let { secureKeyValueLocalStorage.setAuthToken(it) }
                    onLoadDB()
                }, onCancelled = onLoadDB, onConnectFailure = onLoadDB)
        }, onCancelled = onLoadDB, onConnectFailure = onLoadDB)
    }

}


@Preview(showBackground = true)
@Composable
fun ECPreview() {
    ECTheme {
        val model = CompetitionsModel("1", "African cup", "Africa", "")
        CompetitionsList(listOf(model, model, model)) {

        }
    }
}