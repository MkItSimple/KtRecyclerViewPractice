package com.example.ktrecyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PokemonDetailsActivity : AppCompatActivity() {

    var pokemon: Pokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getParcelableExtra<Pokemon>(PokemonListActivity.USER_KEY)

        supportActionBar?.title = pokemon?.name
    }
}
