package com.example.memeapplication_jetpackcompose.repository

import android.net.Network
import android.util.Log
import androidx.compose.runtime.referentialEqualityPolicy
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.memeapplication_jetpackcompose.api.MemeApi
import com.example.memeapplication_jetpackcompose.models.MemeApiDataClass
import com.example.memeapplication_jetpackcompose.utils.NetworkResult
import javax.inject.Inject


class MemeRepository @Inject constructor(private val memeApi: MemeApi) {


    suspend fun getMemeData(): NetworkResult<MemeApiDataClass> {
        return try {

            val response = memeApi.getMemeApi()
//            Log.d("checkingData",response.toString())
//            Log.d("checkingData",response.body().toString())

            try {
                Log.d("checkingData", response.toString())
                Log.d("checkingData", response.body().toString())
            } catch (e: Exception) {
                Log.d("checkingData", "Exception ${e.toString()}")

            }
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body())
            } else {
                NetworkResult.Error(response.message())
            }


//          NetworkResult.Error("")
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "An unknown error occurred")
        }
    }


}