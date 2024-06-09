package com.example.memeapplication_jetpackcompose.ui.homePackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memeapplication_jetpackcompose.models.MemeApiDataClass
import com.example.memeapplication_jetpackcompose.repository.MemeRepository
import com.example.memeapplication_jetpackcompose.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MemeViewModel @Inject constructor(private val memeRepository: MemeRepository ) :ViewModel() {




    fun refreshData() {
        getMemeData()
    }


    private val _memeState = MutableStateFlow<NetworkResult<MemeApiDataClass>>(NetworkResult.Loading())
    val state: StateFlow<NetworkResult<MemeApiDataClass>> = _memeState

    fun getMemeData(){
        viewModelScope.launch {

            _memeState.value= memeRepository.getMemeData()
        }
    }


}