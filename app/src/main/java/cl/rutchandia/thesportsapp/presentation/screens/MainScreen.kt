package cl.rutchandia.thesportsapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cl.rutchandia.thesportsapp.R
import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country
import cl.rutchandia.thesportsapp.presentation.composables.CardCountry
import cl.rutchandia.thesportsapp.presentation.composables.CenteredProgressIndicator
import cl.rutchandia.thesportsapp.presentation.composables.LoadingErrorBox
import cl.rutchandia.thesportsapp.presentation.composables.TryAgainButton
import cl.rutchandia.thesportsapp.presentation.viewmodel.CountryViewModel

@Composable
fun MainScreen(
    viewModel: CountryViewModel = hiltViewModel()
) {
    val countries = viewModel.countryList.collectAsStateWithLifecycle()
    val apiState by viewModel.apiState

    MainScreenContent(
        countries = countries.value ?: listOf(),
        onTryAgain = viewModel::tryAgain,
        apiState = apiState
    )

    LoadingErrorBox(
        state = apiState, onResetStatus = viewModel::resetApiStatus
    )
}

@Composable
private fun MainScreenContent(
    countries: List<Country>,
    onTryAgain: () -> Unit,
    apiState: ApiResponseState<*>?,
) {
    when (apiState) {
        is ApiResponseState.Loading -> {
            CenteredProgressIndicator()
        }

        is ApiResponseState.Success -> {
            if (countries.isNotEmpty()) {
                CountryList(
                    countries = countries
                )
            }
        }

        is ApiResponseState.Error -> {
            TryAgainButton(onTryAgain, apiState.messageId)
        }

        null -> {
            TryAgainButton(onTryAgain, R.string.loading_message)
        }
    }
}

@Composable
private fun CountryList(
    countries: List<Country>
) {
    var searchText by remember { mutableStateOf("") }
    val filteredCountries = remember(countries, searchText) {
        derivedStateOf {
            countries.filter { country ->
                country.name.contains(searchText, ignoreCase = true)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text(text = stringResource(R.string.search)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface.copy(alpha = 1.0f),
                unfocusedContainerColor = colorScheme.surface.copy(alpha = 1.0f),
                unfocusedIndicatorColor = colorScheme.primary.copy(alpha = 0.8f),
                unfocusedLabelColor = colorScheme.primary.copy(alpha = 0.8f),
            )
        )
        LazyColumn {
            items(filteredCountries.value) { country ->
                CardCountry(
                    countryName = country.name,
                    countryFlag = country.flagUrl
                )
            }
        }
    }
}
