package com.example.kukufmassignment.repo

import com.example.kukufmassignment.base.BaseRepository
import com.example.kukufmassignment.data.database.SpaceXLaunchesDatabase
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.manager.api.NetworkManager
import com.example.kukufmassignment.manager.db.IDatabaseManager
import javax.inject.Inject

class SpaceXDetailRepository @Inject constructor(
    networkManager: NetworkManager,
    databaseManager: IDatabaseManager,
    spaceXLaunchesDatabase: SpaceXLaunchesDatabase,
    appDispatchers: IDispatcherProvider
): BaseRepository(networkManager, databaseManager, spaceXLaunchesDatabase, appDispatchers) {
}