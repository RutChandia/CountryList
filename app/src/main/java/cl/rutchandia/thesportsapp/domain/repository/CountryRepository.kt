package cl.rutchandia.thesportsapp.domain.repository

import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country

interface CountryRepository {
    suspend fun getAllCountries(): ApiResponseState<List<Country>>
}