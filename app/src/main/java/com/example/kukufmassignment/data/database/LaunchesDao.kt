package com.example.kukufmassignment.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.kukufmassignment.model.SpaceXItem

@Dao
interface LaunchesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpaceXLaunches(launches: List<SpaceXItem>)

    @Query("SELECT * FROM spacex_table")
    fun getSpaceXLaunches(): List<SpaceXItem>

    @Query("SELECT * FROM spacex_table WHERE (LOWER(mission_name) LIKE LOWER(:query || '%'))")
    fun searchSpaceXLaunches(query: String): List<SpaceXItem>


    @Update
    fun updateSpaceXLaunchesInDb(spaceXItem: SpaceXItem)

    @Query("SELECT * FROM spacex_table WHERE isFavorite = 1")
    fun getFavouriteLaunches(): List<SpaceXItem>
}