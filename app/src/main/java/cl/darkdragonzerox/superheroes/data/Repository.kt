package cl.darkdragonzerox.superheroes.data

import android.util.Log
import androidx.lifecycle.LiveData

class Repository{

    private val superHeroDao=SuperHeroApplication.superHeroDatabase!!
    val superList= superHeroDao.superHeroDao().getSuperHero()

    suspend fun getSuperHeroesfromApi(){

        val response=RetrofitClient.instance().getSuperHero()

        when(response.isSuccessful){

            true -> { response.body()?.let{
                Log.d("Repo", "getSuperHeroes con :${it.size} heroes ")
                superHeroDao.superHeroDao().loadHeros(it)
            }}

            false-> {
                Log.d("Repo", "getSuperHeroes: ${response.errorBody()}")

            }
        }

    }
    fun getHero(idCode:Int  ) : LiveData<SuperHero>
    {
        return superHeroDao.superHeroDao().getHeroDetail(idCode)
    }
}