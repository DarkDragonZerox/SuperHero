package cl.darkdragonzerox.superheroes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.darkdragonzerox.superheroes.data.SuperHero
import cl.darkdragonzerox.superheroes.databinding.ItemListBinding
import coil.load

class HeroAdapter(val listener:OnItemClickListener) : RecyclerView.Adapter<HeroVH>() {
    private val listaHero = mutableListOf<SuperHero>()




    fun updateHero(heroList :List<SuperHero>){
        listaHero.clear()
        listaHero.addAll(heroList)
        notifyDataSetChanged()

    }
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        val binding=(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
         return HeroVH(binding)
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
     val hero= listaHero[position]

     holder.itemView.setOnClickListener{
         listener.onClick(hero.id)
     }
        holder.bind(hero)
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
