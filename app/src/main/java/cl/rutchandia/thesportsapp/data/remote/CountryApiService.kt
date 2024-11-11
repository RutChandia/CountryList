package cl.rutchandia.thesportsapp.data.remote

import cl.rutchandia.thesportsapp.data.model.CountryDto
import retrofit2.http.GET

interface CountryApiService {
    @GET("all_countries.php")
    suspend fun getAllCountries(): List<CountryDto>
}