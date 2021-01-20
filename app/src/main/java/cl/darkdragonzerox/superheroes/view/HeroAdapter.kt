package cl.darkdragonzerox.superheroes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.darkdragonzerox.superheroes.data.SuperHero
import cl.darkdragonzerox.superheroes.databinding.ItemListBinding
import coil.load

class HeroAdapter : RecyclerView.Adapter<HeroVH>() {
    private var listaHero = listOf<SuperHero>()
    private val selectedHero= MutableLiveData<SuperHero>()
    fun selectedHero():LiveData<SuperHero> = selectedHero
    fun updateHero(heroList :List<SuperHero>){
        listaHero=heroList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        return HeroVH(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
     val hero= listaHero[position]
     holder.bind(hero)
     holder.itemView.setOnClickListener{
         selectedHero.value=hero
     }
    }

    override fun getItemCount() = listaHero.size
}

class HeroVH(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(superHero: SuperHero){
        binding.tvName.text = superHero.name
        binding.tvFullname.text=superHero.biography.fullName
        binding.tvAlignment.text=superHero.biography.alignment
        binding.tvPublisher.text=superHero.biography.publisher
        binding.ivHero.load(superHero.images.lg)
    }

}
