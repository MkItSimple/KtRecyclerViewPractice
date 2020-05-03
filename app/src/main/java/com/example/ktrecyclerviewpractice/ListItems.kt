package com.example.ktrecyclerviewpractice

import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.row_pokemon_list.view.*

class PokemonItems(val pokemon: Pokemon) : Item<ViewHolder>() {
    override fun getLayout() = R.layout.row_pokemon_list

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.pokemonName.text = pokemon.name
    }
}