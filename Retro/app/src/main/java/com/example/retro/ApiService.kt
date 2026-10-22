package com.example.retro

import androidx.contentpager.content.Query
import com.example.retro.Data.Game
import com.example.retro.Data.Posts
import com.example.retro.Data.Todo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("games")
    suspend fun getGames(): List<Game>
    @GET("games")
    suspend fun getGamesByGenre(@retrofit2.http.Query("genre") genre: String): List<Game>
    @GET("games/{gameId}")
    suspend fun getGameById(@Path("gameId") gameId: Int): Game
    @GET("todos")
    suspend fun getTodos(): List<Todo>
    @GET("posts")
    suspend fun getPosts(): List<Posts>

}


