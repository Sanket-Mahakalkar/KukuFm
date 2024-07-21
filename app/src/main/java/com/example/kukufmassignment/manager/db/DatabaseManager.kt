package com.example.kukufmassignment.manager.db

import com.example.kukufmassignment.data.database.LaunchesDao
import com.example.kukufmassignment.model.SpaceXItem
import javax.inject.Inject

class DatabaseManager @Inject constructor(
    private val launchesDao: LaunchesDao
): IDatabaseManager {


    override suspend fun storeSpaceXLaunchesInDb(spaceXList: List<SpaceXItem>?) {
        spaceXList?.let { launchesDao.insertSpaceXLaunches(it) }
    }

    override suspend fun getSpaceXLaunchesFromDb(): List<SpaceXItem> {
       return launchesDao.getSpaceXLaunches()
    }

    override suspend fun searchSpaceXLaunches(query: String): List<SpaceXItem> {
        return launchesDao.searchSpaceXLaunches(query)
    }

    override suspend fun updateSpaceXLaunchesInDb(spaceXItem: SpaceXItem) {
        launchesDao.updateSpaceXLaunchesInDb(spaceXItem)
    }

    override suspend fun getFavouriteLaunches(): List<SpaceXItem> {
        return launchesDao.getFavouriteLaunches()
    }


}