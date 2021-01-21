package cl.darkdragonzerox.superheroes.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.darkdragonzerox.superheroes.data.SuperHero
import cl.darkdragonzerox.superheroes.databinding.ItemListBinding
import coil.load

class HeroAdapter(val listener:OnItemClickListener) : RecyclerView.Adapter<HeroVH>() {
    private val superHeroList = mutableListOf<SuperHero>()

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context))
         return HeroVH(binding)
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
     val superHero= superHeroList[position]

         holder.itemView.setOnClickListener{
         listener.onClick(superHero.id)
     }
        holder.bind(superHero)
    }

    override fun getItemCount(): Int{
    return superHeroList.size
    }
    fun updateHero(heroList :List<SuperHero>){
        superHeroList.clear()
        superHeroList.addAll(heroList)
        notifyDataSetChanged()
        Log.d("update","$heroList")
    }
}

class HeroVH(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(superHero: SuperHero){
        binding.tvName.text = superHero.name
        binding.tvFullname.text=superHero.biography.fullName
        binding.tvAlignment.text=superHero.biography.alignment
        binding.tvPublisher.text=superHero.biography.publisher
        binding.ivHero.load(superHero.images.lg)
        Log.d("create on bind"," $superHero")
    }

}
