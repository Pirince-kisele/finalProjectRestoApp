package com.example.restoapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Food(
    val  id: Int,
    @DrawableRes val imageId: Int,
    @StringRes val name: Int,
    @StringRes val price: Int,
    @StringRes val snippet: Int,
    @StringRes val description: Int,
)
