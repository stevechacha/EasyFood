package com.steve.easyfood.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FoodItemEntity::class],
    version = 1
)
abstract class FoodDatabase  : RoomDatabase(){
    abstract val foodDao: FoodDao
}