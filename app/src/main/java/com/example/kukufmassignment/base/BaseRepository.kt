package com.example.kukufmassignment.base

import com.example.kukufmassignment.data.database.SpaceXLaunchesDatabase
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.manager.api.INetworkManager
import com.example.kukufmassignment.manager.db.IDatabaseManager

open class BaseRepository(
    private val networkManager: INetworkManager,
    private val databaseManager: IDatabaseManager,
    private val spaceXLaunchesDatabase: SpaceXLaunchesDatabase,
    private val appDispatchers: IDispatcherProvider
) {

    fun getDatabase() = spaceXLaunchesDatabase

    fun getNetworkManager() = networkManager

    fun getDatabaseManager() = databaseManager

    fun getAppDispatchers() = appDispatchers
}