package com.example.memeapplication_jetpackcompose.ui.homePackage

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.memeapplication_jetpackcompose.api.MemeApi
import com.example.memeapplication_jetpackcompose.models.MemeApiDataClass
import com.example.memeapplication_jetpackcompose.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.annotations.Async


@Composable
fun HomeScreen(viewModel: MemeViewModel = hiltViewModel()){

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getMemeData() // Initial API call when HomeScreen is first composed
    }


    when (state) {
        is NetworkResult.Loading -> {

        }
        is NetworkResult.Success -> {
            val memeData = (state as NetworkResult.Success<MemeApiDataClass>).data
            memeData?.let {
                MemeContent(memeData = it) {
                    // Callback to re-fetch the data from the API when next button is clicked
                    viewModel.getMemeData()
                }
            }
        }
        is NetworkResult.Error -> {
            val message = (state as NetworkResult.Error<MemeApiDataClass>).message
            // Show error message
            Text(text = message ?: "Unknown error")
        }
        else ->{}

    }





}

@Composable
fun MemeContent(memeData:MemeApiDataClass,
                onNextClicked: () -> Unit){
    val context = LocalContext.current

    Column {

        AsyncImage(modifier = Modifier
            .weight(.9f),
            contentDescription ="meme Image ",
            model = ImageRequest.Builder(context).data(memeData.url).build(),
        )

        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()){
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, contentDescription ="Back arrow " )
            }

            TextButton(onClick ={} ) {
                Text(text = "Share Meme")
            }

            IconButton(onClick =  onNextClicked ) {
                Icon(Icons.Filled.ArrowForward, contentDescription ="Back arrow " )
            }

        }


    }
}