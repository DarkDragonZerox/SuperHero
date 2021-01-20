package cl.darkdragonzerox.superheroes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.darkdragonzerox.superheroes.data.Repository
import kotlinx.coroutines.launch

class HeroViewModel : ViewModel() {
    private val repository = Repository()
    val herolist =repository.superList

    init {
        viewModelScope.launch { repository.getSuperHeroesfromApi() }
    }

}