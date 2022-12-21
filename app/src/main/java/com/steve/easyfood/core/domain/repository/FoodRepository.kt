package com.steve.easyfood.core.presentation.domain.repository

import com.steve.easyfood.core.data.local.database.FoodItemEntity
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun insertFoodItem(foodItemEntity: FoodItemEntity)

    fun getAllFoods(): Flow<List<FoodItemEntity>>
}