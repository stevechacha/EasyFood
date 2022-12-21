package com.steve.easyfood.core.presentation.domain.model

data class FoodItem(
    val foodName: String,
    val price: Double,
    val onAdd: Boolean
)