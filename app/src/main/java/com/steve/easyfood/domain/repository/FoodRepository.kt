package com.steve.easyfood.domain.repository

import com.steve.easyfood.data.local.database.FoodItemEntity
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun insertFoodItem(foodItemEntity: FoodItemEntity)

    fun getAllFoods(): Flow<List<FoodItemEntity>>
}