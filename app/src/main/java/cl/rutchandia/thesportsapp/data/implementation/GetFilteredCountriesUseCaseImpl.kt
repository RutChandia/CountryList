package cl.rutchandia.thesportsapp.data.implementation

import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country
import cl.rutchandia.thesportsapp.domain.repository.CountryRepository
import cl.rutchandia.thesportsapp.domain.usecase.GetFilteredCountriesUseCase
import javax.inject.Inject

class GetFilteredCountriesUseCaseImpl @Inject constructor(
    private val countryRepository: CountryRepository
) : GetFilteredCountriesUseCase {
    override suspend operator fun invoke(): ApiResponseState<List<Country>> {
        return when (val result = countryRepository.getAllCountries()) {
            is ApiResponseState.Success -> {
                val filteredCountries =
                    result.data.filter { country ->
                        country.name.startsWith(
                            "C",
                            ignoreCase = true
                        )
                    }
                ApiResponseState.Success(filteredCountries)
            }

            is ApiResponseState.Error -> result
            is ApiResponseState.Loading -> result
        }
    }
}