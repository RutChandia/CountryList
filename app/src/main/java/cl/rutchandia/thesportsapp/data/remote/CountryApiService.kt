package cl.rutchandia.thesportsapp.data.remote

import cl.rutchandia.thesportsapp.data.model.CountryResponse
import retrofit2.http.GET

interface CountryApiService {
    @GET("all_countries.php")
    suspend fun getAllCountries(): CountryResponse
}