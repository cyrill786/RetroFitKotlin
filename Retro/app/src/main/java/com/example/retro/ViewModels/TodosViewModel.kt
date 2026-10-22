package com.example.retro.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retro.ApiClient
import com.example.retro.Data.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TodosViewModel : ViewModel() {
    val todos = MutableStateFlow<List<Todo>>(emptyList())

    fun loadTodos() {
        viewModelScope.launch {
            try {
                todos.value = ApiClient.apiService.getTodos()
            } catch (e: Exception) {
                Log.e("TodoVM", "Erreur: ${e.message}")
            }
        }
    }
}
