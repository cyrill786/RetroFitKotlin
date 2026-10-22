package com.example.retro.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JeuVideo(
    @SerialName("idGame") val idJeu: Int,
    @SerialName("name") val nom: String,
    @SerialName("releaseDate") val dateSortie: String,
    @SerialName("rating") val note: Double
)
