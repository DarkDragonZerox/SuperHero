package cl.darkdragonzerox.superheroes.data

import retrofit2.Response
import retrofit2.http.GET

interface SuperApi {

    @GET("/all.json")
    suspend fun getSuperHero(): Response<List<SuperHero>>
}