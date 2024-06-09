package com.example.memeapplication_jetpackcompose.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {

    private var prefs = context.getSharedPreferences(Constants.PREFS_TOKEN_FILE,Context.MODE_PRIVATE)





}