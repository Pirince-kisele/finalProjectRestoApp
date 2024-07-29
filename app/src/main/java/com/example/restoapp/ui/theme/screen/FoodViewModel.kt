package com.example.restoapp.ui.theme.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.lifecycle.ViewModel


class FoodViewModel: ViewModel() {
  var showComposable: Boolean = false
  fun showComposableChange(value: Boolean) {
    showComposable = value
  }
  }