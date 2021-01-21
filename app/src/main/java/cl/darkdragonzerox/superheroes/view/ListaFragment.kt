package cl.darkdragonzerox.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import cl.darkdragonzerox.superheroes.R
import cl.darkdragonzerox.superheroes.databinding.FragmentListaBinding
import cl.darkdragonzerox.superheroes.viewmodel.HeroViewModel

class ListaFragment : Fragment(), OnItemClickListener {
    private val viewModel :HeroViewModel by activityViewModels()
    private lateinit var binding: FragmentListaBinding


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        binding = FragmentListaBinding.inflate(layoutInflater)
        val adapter= HeroAdapter(this)
        binding.rvHero.adapter = adapter
        binding.rvHero.layoutManager=LinearLayoutManager(context)



        viewModel.herolist.observe(viewLifecycleOwner, {heroList->heroList?.let {
            adapter.updateHero(it )
        }

        })


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


