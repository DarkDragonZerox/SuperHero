package cl.darkdragonzerox.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.darkdragonzerox.superheroes.databinding.ActivityMainBinding
import cl.darkdragonzerox.superheroes.view.ListaFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.
        beginTransaction().replace(R.id.main_container,ListaFragment()).
        addToBackStack("back").
        commit()

        setContentView(binding.root)


    }

}