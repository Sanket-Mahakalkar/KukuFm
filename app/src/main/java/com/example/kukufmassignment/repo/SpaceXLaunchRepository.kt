package com.example.kukufmassignment.repo

import com.example.kukufmassignment.base.BaseRepository
import com.example.kukufmassignment.data.database.SpaceXLaunchesDatabase
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.manager.api.NetworkManager
import com.example.kukufmassignment.manager.db.IDatabaseManager
import com.example.kukufmassignment.model.SpaceXItem
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpaceXLaunchRepository @Inject constructor(
    networkManager: NetworkManager,
    databaseManager: IDatabaseManager,
    spaceXLaunchesDatabase: SpaceXLaunchesDatabase,
    appDispatchers: IDispatcherProvider
): BaseRepository(networkManager, databaseManager, spaceXLaunchesDatabase, appDispatchers) {

    suspend fun getSpaceXLaunches() = withContext(getAppDispatchers().io()){
        getNetworkManager().getSpaceXLaunches()
    }

    suspend fun storeSpaceXLaunchesInDb(result: List<SpaceXItem>?) = withContext(getAppDispatchers().io()) {
        getDatabaseManager().storeSpaceXLaunchesInDb(result)

    }

    suspend fun getSpaceXLaunchesFromDb() = withContext(getAppDispatchers().io()) {
        getDatabaseManager().getSpaceXLaunchesFromDb()
    }

    suspend fun searchSpaceXLaunches(query: String) = withContext(getAppDispatchers().io()) {
        getDatabaseManager().searchSpaceXLaunches(query)
    }

    suspend fun updateSpaceXLaunchesInDb(spaceXItem: SpaceXItem) = withContext(getAppDispatchers().io()){
        getDatabaseManager().updateSpaceXLaunchesInDb(spaceXItem)
    }

    fun mergeWithLocalData(
        apiResult: List<SpaceXItem>?,
        localData: List<SpaceXItem>
    ): List<SpaceXItem> {

        if(apiResult.isNullOrEmpty()) return localData
        if(localData.isEmpty()) return apiResult

        val localItemMap = localData.associateBy { it.flight_number }
        apiResult.forEach {
            if(localItemMap.containsKey(it.flight_number) && localItemMap[it.flight_number] != null){
                it.isFavorite = localItemMap[it.flight_number]!!.isFavorite
            }
        }
        return apiResult
    }

}