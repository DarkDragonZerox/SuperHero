package cl.darkdragonzerox.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.darkdragonzerox.superheroes.databinding.FragmentDetailBinding
import cl.darkdragonzerox.superheroes.databinding.FragmentListaBinding
import cl.darkdragonzerox.superheroes.viewmodel.HeroViewModel
import coil.load


class DetailFragment : Fragment(){
    lateinit var binding: FragmentDetailBinding
    private val viewModel : HeroViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentDetailBinding.inflate(layoutInflater)
        viewModel.getHeroDetail().observe(viewLifecycleOwner,{
           it?.let{
               binding.ivHeroDetail.load(it.images.lg)
               binding.tvNameDetail.text= it.name
               binding.tvRealNameDetail.text=it.biography.fullName
               binding.tvIntDetail.text=it.powerstats.intelligence.toString()
               binding.tvStrDetail.text=it.powerstats.strength.toString()
               binding.tvSpdDetail.text=it.powerstats.speed.toString()
               binding.tvPowDetail.text=it.powerstats.power.toString()
               binding.tvDurDetail.text=it.powerstats.durability.toString()
               binding.tvCmbDetail.text=it.powerstats.combat.toString()
               binding.tvGeneroDetail.text=it.appearance.gender
               binding.tvAlturaDetail.text=it.appearance.height.toString()
               binding.tvPesoDetail.text=it.appearance.weight.toString()
               binding.tvAffiliacionDetail.text =it.biography.alignment
               binding.tvNacimientoDetail.text=it.biography.placeOfBirth

           }
        })
        return binding.root

    }

}