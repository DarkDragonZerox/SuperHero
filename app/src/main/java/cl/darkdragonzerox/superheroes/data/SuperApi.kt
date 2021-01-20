package cl.darkdragonzerox.superheroes.data

import retrofit2.Response
import retrofit2.http.GET

interface SuperApi {

    @GET("/all")
    suspend fun getSuperHeroFromApi(): Response<List<SuperHero>>
}