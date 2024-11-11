package cl.rutchandia.thesportsapp.data.repository

import cl.rutchandia.thesportsapp.data.mapper.CountryMapper
import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.data.remote.CountryApiService
import cl.rutchandia.thesportsapp.data.remote.doNetworkCall
import cl.rutchandia.thesportsapp.domain.model.Country
import cl.rutchandia.thesportsapp.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val apiService: CountryApiService, private val mapper: CountryMapper
) : CountryRepository {

    override suspend fun getAllCountries(): ApiResponseState<List<Country>> {
        return doNetworkCall {
            val response = apiService.getAllCountries()
            mapper.dtoToDomain(response)
        }
    }
}