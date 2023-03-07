package com.example.breastcancerlocal

import android.app.Application
import androidx.room.Room
import com.example.breastcancerlocal.database.BreastCancerDatabase

class BreastCancerApplication : Application() {

    companion object {
        lateinit var database: BreastCancerDatabase
            private set
    }
    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(
                this,
                BreastCancerDatabase::class.java,
                "breastCancerDatabase"
            )
            .build() }
}
