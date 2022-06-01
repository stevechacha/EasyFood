package com.steve.easyfood.presentation.confirmlocationscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LocationViewModel: ViewModel() {

    private val _cityText = mutableStateOf("")
    val cityText: State<String> = _cityText

    private val _areaText = mutableStateOf("")
    val areaText: State<String> = _areaText

    fun setCityText(city: String) {
        _cityText.value = city
    }

    fun setAreaText(area: String) {
        _areaText.value = area
    }
}