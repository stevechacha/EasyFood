package com.steve.easyfood.core.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodItem(foodItemEntity: FoodItemEntity)

    @Query("SELECT * FROM foods")
    fun getAllFoods(): Flow<List<FoodItemEntity>>

}