package com.example.kukufmassignment.di

import android.content.Context
import com.example.kukufmassignment.data.database.LaunchesDao
import com.example.kukufmassignment.data.database.SpaceXLaunchesDatabase
import com.example.kukufmassignment.dispatcher.AppDispatcherProvider
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.manager.api.INetworkManager
import com.example.kukufmassignment.manager.api.NetworkManager
import com.example.kukufmassignment.manager.db.DatabaseManager
import com.example.kukufmassignment.manager.db.IDatabaseManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNetworkManager(networkManager: NetworkManager): INetworkManager{
        return networkManager
    }

    @Singleton
    @Provides
    fun provideAppDispatchers(appDispatchers: AppDispatcherProvider): IDispatcherProvider {
        return appDispatchers
    }

    @Singleton
    @Provides
    fun provideDatabaseManager(databaseManager: DatabaseManager): IDatabaseManager {
        return databaseManager
    }

    @Singleton
    @Provides
    fun provideSpaceXDatabase( @ApplicationContext context: Context): SpaceXLaunchesDatabase {
        return SpaceXLaunchesDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideLaunchesDao(database: SpaceXLaunchesDatabase): LaunchesDao {
        return database.launchesDao()
    }
}