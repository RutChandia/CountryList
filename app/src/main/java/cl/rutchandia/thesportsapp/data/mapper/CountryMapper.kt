package cl.rutchandia.thesportsapp.data.mapper

import cl.rutchandia.thesportsapp.data.model.CountryDto
import cl.rutchandia.thesportsapp.domain.model.Country
import javax.inject.Inject

class CountryMapper @Inject constructor() {
    fun dtoToDomain(dtoList: List<CountryDto>): List<Country> {
        return dtoList.map { country ->
            Country(
                name = country.name,
                flagUrl = country.flagUrl
            )
        }
    }
}