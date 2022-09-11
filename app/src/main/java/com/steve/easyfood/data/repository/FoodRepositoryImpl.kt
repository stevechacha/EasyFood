package com.steve.easyfood.data.repository

import com.steve.easyfood.data.local.database.FoodDao
import com.steve.easyfood.data.local.database.FoodDatabase
import com.steve.easyfood.data.local.database.FoodItemEntity
import com.steve.easyfood.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepositoryImpl(
    private val dao: FoodDao

) : FoodRepository{
    override suspend fun insertFoodItem(foodItemEntity: FoodItemEntity) {
        dao.insertFoodItem(foodItemEntity)

    }
    override fun getAllFoods(): Flow<List<FoodItemEntity>> {
        return dao.getAllFoods()
    }
}