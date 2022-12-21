package com.steve.easyfood.core.presentation.homescreen

import androidx.lifecycle.ViewModel
import com.steve.easyfood.core.presentation.domain.usecases.FoodUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val foodUseCases: FoodUseCases): ViewModel(){

}