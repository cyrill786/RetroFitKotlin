package com.example.retro.Data

import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val idGame: Int,
    val name: String,
    val releaseDate: String,
    val rating: Double
)
