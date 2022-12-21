package com.steve.easyfood.core.presentation.data.repository

import com.steve.easyfood.core.data.local.database.FoodDao
import com.steve.easyfood.core.data.local.database.FoodItemEntity
import com.steve.easyfood.core.presentation.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow

class FoodRepositoryImpl(
    private val dao: FoodDao

) : FoodRepository {
    override suspend fun insertFoodItem(foodItemEntity: FoodItemEntity) {
        dao.insertFoodItem(foodItemEntity)

    }
    override fun getAllFoods(): Flow<List<FoodItemEntity>> {
        return dao.getAllFoods()
    }
}