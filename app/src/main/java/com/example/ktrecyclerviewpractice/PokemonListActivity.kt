package com.example.ktrecyclerviewpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import kotlinx.android.synthetic.main.row_pokemon_list.view.*

// p1
class PokemonListActivity : AppCompatActivity() {

    companion object {
        val TAG = "PokemonList"
        val USER_KEY = "USER_KEY"
    }

    //private val pokemons = listOf<Pokemon>(
    //    Pokemon("c1"),
    //    Pokemon("c2"),
    //   Pokemon("c3")
    //)

    private val pokemons = listOf<Pokemon>(
        Pokemon(1, "c1"),
        Pokemon(2, "c2"),
        Pokemon(3, "c3"),
        Pokemon(4, "c4"),
        Pokemon(5, "c5"),
        Pokemon(6, "c6")
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
            adapter.add(PokemonItems(pokemon))
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

class PokemonItems(val pokemon: Pokemon) : Item<ViewHolder>() {
    override fun getLayout() = R.layout.row_pokemon_list

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.pokemonName.text = pokemon.name
    }
}
