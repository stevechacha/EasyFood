package com.steve.easyfood.core.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "foods")
data class FoodItemEntity(
    val foodName: String,
    val price: Double,
    @PrimaryKey val id: Int,
)
class InvalidFoodException(message: String): Exception(message)
