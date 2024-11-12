package cl.rutchandia.thesportsapp.domain.usecase

import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country

interface GetFilteredCountriesUseCase {
    suspend operator fun invoke(): ApiResponseState<List<Country>>
}