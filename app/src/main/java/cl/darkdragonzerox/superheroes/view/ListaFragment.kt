package cl.darkdragonzerox.superheroes.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager


import cl.darkdragonzerox.superheroes.R
import cl.darkdragonzerox.superheroes.databinding.FragmentListaBinding
import cl.darkdragonzerox.superheroes.viewmodel.HeroViewModel

class ListaFragment : Fragment(), OnItemClickListener {
    private lateinit var binding: FragmentListaBinding
    private val viewModel :HeroViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListaBinding.inflate(layoutInflater)
        val adapter= HeroAdapter(this)
        val recycler=binding.rvHero
        recycler.adapter=adapter
        recycler.layoutManager=LinearLayoutManager(context)

        viewModel.herolist.observe(viewLifecycleOwner, {herolist->herolist?.let {
           adapter.updateHero(it)

            Log.d("listener","listener ${it.size}")
        }

        })

        Log.d("oncreate ", "prueba on create")
        return binding.root
    }

    override fun onClick(id: Int) {
        activity?.supportFragmentManager?.
        beginTransaction()?.
        replace(R.id.main_container,DetailFragment(id))?.
        addToBackStack("back")?.
        commit()

    }


    }


