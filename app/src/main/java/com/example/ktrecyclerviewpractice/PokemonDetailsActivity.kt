package com.example.ktrecyclerviewpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pokemon_details.*

class PokemonDetailsActivity : AppCompatActivity() {
    companion object {
        val TAG = "PokemonDetails"
    }

    private val pokemonDetails = listOf<PokemonDetails>(
        PokemonDetails(1,101, 201),
        PokemonDetails(2,102, 202),
        PokemonDetails(3,103, 203),
        PokemonDetails(4,104, 204),
        PokemonDetails(5,105, 205),
        PokemonDetails(6,106, 206)
    )

    var pokemon: Pokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getParcelableExtra<Pokemon>(PokemonListActivity.USER_KEY)
        val pid = pokemon!!.id - 1

        supportActionBar?.title = pokemon.id.toString()

        pokemonWeight.text = pokemonDetails.elementAt(pid).weight.toString()
        pokemonHeight.text = pokemonDetails.elementAt(pid).height.toString()
    }
}

