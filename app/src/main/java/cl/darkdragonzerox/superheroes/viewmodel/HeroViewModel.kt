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
        viewModelScope.launch { repository.getSuperHeroes() }
    }
    private lateinit var selectedHero : SuperHero
    fun selected(superHero: SuperHero){
        selectedHero= superHero
    }

    fun getHeroDetail() : LiveData<SuperHero>
    {
       return repository.getHero(selectedHero.id)
    }
}