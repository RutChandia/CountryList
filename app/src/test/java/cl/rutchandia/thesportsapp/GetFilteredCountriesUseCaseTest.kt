package cl.rutchandia.thesportsapp

import cl.rutchandia.thesportsapp.data.implementation.GetFilteredCountriesUseCaseImpl
import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country
import cl.rutchandia.thesportsapp.domain.repository.CountryRepository
import cl.rutchandia.thesportsapp.domain.usecase.GetFilteredCountriesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetFilteredCountriesUseCaseTest {

    private val countryRepository = mockk<CountryRepository>()
    private lateinit var getCountriesUseCase: GetFilteredCountriesUseCase

    @Before
    fun setUp() {
        getCountriesUseCase = GetFilteredCountriesUseCaseImpl(countryRepository)
    }

    @Test
    fun `invoke should filter countries starting with C`() = runBlocking {
        val countryList = listOf(
            Country("Canada", "url_to_flag"),
            Country("Chile", "url_to_flag"),
            Country("Argentina", "url_to_flag")
        )
        coEvery { countryRepository.getAllCountries() } returns ApiResponseState.Success(countryList)

        val result = getCountriesUseCase()

        assertTrue(result is ApiResponseState.Success)
        assertEquals(2, (result as ApiResponseState.Success).data.size)
        assertEquals("Canada", result.data[0].name)
        assertEquals("Chile", result.data[1].name)
    }
}