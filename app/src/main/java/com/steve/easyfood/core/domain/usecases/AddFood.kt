package com.steve.easyfood.core.presentation.domain.usecases

import com.steve.easyfood.core.data.local.database.FoodItemEntity
import com.steve.easyfood.core.data.local.database.InvalidFoodException
import com.steve.easyfood.core.presentation.domain.repository.FoodRepository

class AddFood (private val repository: FoodRepository){
    @Throws(InvalidFoodException::class)
    suspend operator fun invoke(foodItemEntity: FoodItemEntity) {
        if(foodItemEntity.foodName.isBlank()) {
            throw InvalidFoodException("The title of the note can't be empty.")
        }
        if(foodItemEntity.price.toString().isBlank()) {
            throw InvalidFoodException("The content of the note can't be empty.")
        }
        repository.insertFoodItem(foodItemEntity)
    }
}