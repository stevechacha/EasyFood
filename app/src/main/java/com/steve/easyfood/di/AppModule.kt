package com.steve.easyfood.di

import android.content.Context
import androidx.room.Room
import com.steve.easyfood.core.data.local.database.FoodDatabase
import com.steve.easyfood.core.presentation.data.repository.FoodRepositoryImpl
import com.steve.easyfood.core.presentation.domain.repository.FoodRepository
import com.steve.easyfood.core.presentation.domain.usecases.AddFood
import com.steve.easyfood.core.presentation.domain.usecases.FoodUseCases
import com.steve.easyfood.core.presentation.domain.usecases.GetAllFoods
import com.steve.easyfood.core.presentation.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFoodDatabase(@ApplicationContext context: Context): FoodDatabase {
        return Room.databaseBuilder(
            context,
            FoodDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideFoodRepository(database: FoodDatabase): FoodRepository {
        return FoodRepositoryImpl(database.foodDao)
    }

    @Singleton
    @Provides
    fun provideFoodUseCases(repository: FoodRepository): FoodUseCases {
        return FoodUseCases(
            addFood = AddFood(repository),
            getAllFoods = GetAllFoods(repository)
        )
    }


}