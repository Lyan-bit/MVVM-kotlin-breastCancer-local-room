package com.example.breastcancerlocal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.breastcancerlocal.model.BreastCancerEntity

@Database(entities = [(BreastCancerEntity::class)], version = 1, exportSchema = false)
abstract class BreastCancerDatabase : RoomDatabase() {
    abstract fun breastCancerDao(): BreastCancerEntityDAO
}
