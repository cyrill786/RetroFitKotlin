package com.example.retro.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retro.ApiClient
import com.example.retro.Data.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {
    val games = MutableStateFlow<List<Game>>(emptyList())

    fun loadGames() {
        viewModelScope.launch {
            try {
                games.value = ApiClient.apiService.getGames()
            } catch (e: Exception) {
                Log.e("GamesVM", "Erreur: ${e.message}")
            }
        }
    }

}
