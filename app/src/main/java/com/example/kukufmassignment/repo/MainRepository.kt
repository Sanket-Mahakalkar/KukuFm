package com.example.kukufmassignment.repo

import com.example.kukufmassignment.base.BaseRepository
import com.example.kukufmassignment.data.database.SpaceXLaunchesDatabase
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.manager.api.NetworkManager
import com.example.kukufmassignment.manager.db.IDatabaseManager
import com.example.kukufmassignment.model.SpaceXItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    networkManager: NetworkManager,
    databaseManager: IDatabaseManager,
    spaceXLaunchesDatabase: SpaceXLaunchesDatabase,
    appDispatchers: IDispatcherProvider
): BaseRepository(networkManager, databaseManager, spaceXLaunchesDatabase, appDispatchers) {

}