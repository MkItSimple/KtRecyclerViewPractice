package com.example.ktrecyclerviewpractice

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pokemon(val name: String): Parcelable {
    constructor() : this("")
}