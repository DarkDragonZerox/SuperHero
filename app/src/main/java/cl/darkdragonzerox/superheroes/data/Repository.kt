package cl.darkdragonzerox.superheroes.data


import android.util.Log
import androidx.lifecycle.LiveData


class Repository{

    private val superHeroDao=SuperHeroApplication.superHeroDatabase!!.superHeroDao()
    val superList= superHeroDao.getSuperHero()

    suspend fun getSuperHeroes(){

        val response=RetrofitClient.instance().getSuperHeroFromApi()

        when(response.isSuccessful){

            true -> { response.body()?.let{
                Log.d("esta wea","${it.size}" )
                superHeroDao.loadHeros(it)
            }}

            false-> {


            }
        }

    }
    fun getHero(idCode:Int  ) : LiveData<SuperHero>
    {
        return superHeroDao.getHeroDetail(idCode)
    }
}