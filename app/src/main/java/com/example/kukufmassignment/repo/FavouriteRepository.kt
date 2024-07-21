package com.example.kukufmassignment.repo

import com.example.kukufmassignment.base.BaseRepository
import com.example.kukufmassignment.data.database.SpaceXLaunchesDatabase
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.manager.api.NetworkManager
import com.example.kukufmassignment.manager.db.IDatabaseManager
import kotlinx.coroutines.withContext
import javax.inject.Inject

 class FavouriteRepository @Inject constructor (
    networkManager: NetworkManager,
    databaseManager: IDatabaseManager,
    spaceXLaunchesDatabase: SpaceXLaunchesDatabase,
    appDispatchers: IDispatcherProvider
): BaseRepository(networkManager, databaseManager, spaceXLaunchesDatabase, appDispatchers) {

    suspend fun getFavouriteLaunches() = withContext(getAppDispatchers().io()){
        getDatabaseManager().getFavouriteLaunches()
    }
}