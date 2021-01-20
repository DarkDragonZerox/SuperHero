package cl.darkdragonzerox.superheroes.view

import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.darkdragonzerox.superheroes.data.SuperHero

class HeroAdapter : RecyclerView.Adapter<HeroVH>() {
    privare var hero = listOf<SuperHero>()
    private val selectedHero= MutableLiveData<SuperHero>()
    fun selectedHero():LiveData<SuperHero> = selectedHero
    fun updateHero(heroList :List<SuperHero>){
        hero=heroList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        return HeroVH()
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class HeroVH {

}
