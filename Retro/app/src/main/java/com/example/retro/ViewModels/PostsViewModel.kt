package com.example.retro.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retro.ApiClient
import com.example.retro.Data.Posts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    val posts = MutableStateFlow<List<Posts>>(emptyList())

    fun loadPosts() {
        viewModelScope.launch {
            try {
                posts.value = ApiClient.apiService.getPosts()
            } catch (e: Exception) {
                Log.e("PostVM", "Erreur: ${e.message}")
            }
        }
    }
}