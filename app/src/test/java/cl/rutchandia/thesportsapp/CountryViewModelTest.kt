package cl.rutchandia.thesportsapp

import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country
import cl.rutchandia.thesportsapp.domain.usecase.GetFilteredCountriesUseCase
import cl.rutchandia.thesportsapp.presentation.viewmodel.CountryViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CountryViewModelTest {

    @Test
    fun testGetCountriesReturnsNonEmptyListOnSuccess() = runBlocking {
        val dummyCountries = listOf(
            Country("Canada", "url_to_flag"),
            Country("Chile", "url_to_flag")
        )

        val viewModel = CountryViewModel(object : GetFilteredCountriesUseCase {
            override suspend fun invoke(): ApiResponseState<List<Country>> {
                return ApiResponseState.Success(data = dummyCountries.filter {
                    it.name.startsWith(
                        "C",
                        ignoreCase = true
                    )
                })
            }
        })

        val status = viewModel.apiState.value

        if (status is ApiResponseState.Success) {
            assertTrue(status.data.isNotEmpty())
            assertTrue(status.data.all {
                it.name.startsWith("C", ignoreCase = true)
            })
        }
    }

    @Test
    fun testGetCountriesReturnsErrorStateOnFailure() = runBlocking {
        val viewModel = CountryViewModel(object : GetFilteredCountriesUseCase {
            override suspend fun invoke(): ApiResponseState<List<Country>> {
                return ApiResponseState.Error(messageId = 404)
            }
        })

        val status = viewModel.apiState.value

        if (status is ApiResponseState.Error) {
            assertEquals(404, status.messageId)
        }
    }
}