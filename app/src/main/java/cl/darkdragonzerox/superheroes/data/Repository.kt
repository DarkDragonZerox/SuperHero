package cl.darkdragonzerox.superheroes.data


import androidx.lifecycle.LiveData



class Repository {

    private val superDatabase = SuperHeroApplication.superHeroDatabase!!
    val superList = superDatabase.superHeroDao().getSuperHero()

    suspend fun getSuperHeroesFromApi() {

        val response = RetrofitClient.retrofitCliente().getSuperHero()

        when (response.isSuccessful) {

            true -> {
                response.body()?.let {

                    superDatabase.superHeroDao().loadAllHeros(it)
                }
            }

            false -> {}
        }

    }

    fun getHero(idCode: Int): LiveData<SuperHero> {
        return superDatabase.superHeroDao().getHeroDetail(idCode)
    }
}