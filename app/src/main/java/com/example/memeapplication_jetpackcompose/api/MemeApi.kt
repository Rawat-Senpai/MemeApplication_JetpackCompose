package com.example.memeapplication_jetpackcompose.api

import com.example.memeapplication_jetpackcompose.models.MemeApiDataClass
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET


interface MemeApi {
// https://meme-api.com/gimme
    @GET("gimme")
    suspend fun getMemeApi():Response<MemeApiDataClass>

}