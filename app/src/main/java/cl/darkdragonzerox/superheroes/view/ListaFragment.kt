package cl.darkdragonzerox.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.darkdragonzerox.superheroes.R
import cl.darkdragonzerox.superheroes.databinding.FragmentListaBinding
import cl.darkdragonzerox.superheroes.viewmodel.HeroViewModel

class ListaFragment : Fragment(){
    private val viewModel :HeroViewModel by activityViewModels()
    private lateinit var binding: FragmentListaBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListaBinding.inflate(layoutInflater)
        val adapter= HeroAdapter()
        binding.rvHero.layoutManager=LinearLayoutManager(context)
        binding.rvHero.adapter = adapter


        viewModel.herolist.observe(viewLifecycleOwner, {
            it?.let { adapter.updateHero(it) }
        })
        adapter.selectedHero().observe(viewLifecycleOwner,{
            viewModel.selected(it)
            findNavController().navigate(R.id.PasoAdetalle)
        })

        return binding.root
    }

}