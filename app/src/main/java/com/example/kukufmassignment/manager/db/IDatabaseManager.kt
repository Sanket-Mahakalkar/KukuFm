package com.example.kukufmassignment.manager.db

import com.example.kukufmassignment.model.SpaceXItem

interface IDatabaseManager {

    suspend fun storeSpaceXLaunchesInDb(spaceXList: List<SpaceXItem>?)

    suspend fun getSpaceXLaunchesFromDb(): List<SpaceXItem>

    suspend fun searchSpaceXLaunches(query: String): List<SpaceXItem>

   suspend fun updateSpaceXLaunchesInDb(spaceXItem: SpaceXItem)

   suspend fun getFavouriteLaunches() : List<SpaceXItem>


}