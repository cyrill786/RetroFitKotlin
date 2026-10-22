package com.example.retro

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlin.getValue

object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val retrofit by lazy {
        val json = Json { ignoreUnknownKeys = true }
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
    }

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
