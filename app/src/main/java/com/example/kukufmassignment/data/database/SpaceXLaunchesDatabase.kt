package com.example.kukufmassignment.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kukufmassignment.model.SpaceXItem
import com.example.kukufmassignment.utils.Converters

@Database(entities = [SpaceXItem::class], version = 10)
@TypeConverters(Converters::class)
abstract class SpaceXLaunchesDatabase: RoomDatabase() {

    abstract fun launchesDao(): LaunchesDao

    companion object {
        @Volatile
        private var INSTANCE: SpaceXLaunchesDatabase? = null

        fun getDatabase(context: Context): SpaceXLaunchesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpaceXLaunchesDatabase::class.java,
                    "spaceX_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}