package com.example.ktrecyclerviewpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_pokemon_list.*

class PokemonListActivity : AppCompatActivity() {

    companion object {
        val TAG = "PokemonList"
        val USER_KEY = "USER_KEY"
    }

//    private val pokemons = listOf<Pokemon>(
//        Pokemon("c1"),
//        Pokemon("c2"),
//        Pokemon("c3")
//    )

    private val pokemons = listOf<String>(
        "c1",
        "c2",
        "c3",
        "c4",
        "c5",
        "c6"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        supportActionBar?.title = "Pokemon List"

        setupDummyData()
    }

    private fun setupDummyData() {

        val adapter = GroupAdapter<ViewHolder>()

        for (pokemon in pokemons){
            adapter.add(PokemonItems(Pokemon(pokemon)))
        }

        adapter.setOnItemClickListener { item, view ->
            val pokemonItem = item as PokemonItems

            Log.d(TAG, "${pokemonItem.pokemon.name} Clicked!")

            val intent = Intent(view.context, PokemonDetailsActivity::class.java)
            //intent.putExtra(USER_KEY,  userItem.user.username)
            intent.putExtra(USER_KEY, pokemonItem.pokemon)
            startActivity(intent)
            //finish()
        }

        recyclerview_pokemon_list.adapter = adapter
    }
}
