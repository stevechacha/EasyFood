package com.steve.easyfood.presentation.homescreen

import androidx.lifecycle.ViewModel
import com.steve.easyfood.domain.usecases.FoodUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val foodUseCases: FoodUseCases): ViewModel(){

}