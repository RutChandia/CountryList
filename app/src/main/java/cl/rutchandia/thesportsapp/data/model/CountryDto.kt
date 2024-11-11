package cl.rutchandia.thesportsapp.data.model

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name_en") val name: String,
    @SerializedName("flag_url_32") val flagUrl: String
)