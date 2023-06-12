package com.mbialowas.moviefinder.models

data class Character(
    val name:String,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val yearOfBirth: Int,
    val ancestry: String,
    val eyeColour: String,
    val hairColour:String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alive:Boolean,
    val image: String
)
