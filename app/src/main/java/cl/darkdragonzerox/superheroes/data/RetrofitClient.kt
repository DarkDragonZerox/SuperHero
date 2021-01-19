package cl.darkdragonzerox.superheroes.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://akabab.github.io/superhero-api/api"
class RetrofitClient {
    companion object {
        fun instance(): SuperApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(SuperApi::class.java)
        }
    }
}