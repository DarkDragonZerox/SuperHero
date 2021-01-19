package cl.darkdragonzerox.superheroes.data

import android.util.Log

class Repository{

    private val database=SuperHeroApplication.superHeroDatabase!!
    val superList= database.superHeroDao().getSuperHero()

    suspend fun getSuperHeroesfromApi(){

        val response=RetrofitClient.instance().getSuperHero()

        when(response.isSuccessful){

            true -> { response.body()?.let{
                Log.d("Repo", "getSuperHeroes con :${it.size} heroes ")
                database.superHeroDao().loadHeros(it)
            }}

            false-> {
                Log.d("Repo", "getSuperHeroes: ${response.errorBody()}")

            }
        }

    }
}