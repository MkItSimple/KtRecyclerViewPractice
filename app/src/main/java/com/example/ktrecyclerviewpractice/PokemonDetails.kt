package com.example.ktrecyclerviewpractice

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PokemonDetails (val id: Int, val height:Int ,val weight:Int) : Parcelable