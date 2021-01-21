package cl.darkdragonzerox.superheroes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.darkdragonzerox.superheroes.data.Repository
import cl.darkdragonzerox.superheroes.data.SuperHero
import kotlinx.coroutines.launch

class HeroViewModel : ViewModel() {
    private val repository = Repository()
    val herolist =repository.superList

    init {
        viewModelScope.launch { repository.getSuperHeroesFromApi() }
    }
    fun getSuperHerovm(): LiveData<List<SuperHero>>{

        return repository.loadHero()

    }

    fun getHeroDetail(idCode: Int) : LiveData<SuperHero>
    {
       return repository.getHero(idCode)
    }
}