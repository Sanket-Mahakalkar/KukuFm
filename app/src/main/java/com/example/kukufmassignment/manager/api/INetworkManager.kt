package com.example.kukufmassignment.manager.api

import com.example.kukufmassignment.model.SpaceXItem
import retrofit2.Response

interface INetworkManager {

    suspend fun getSpaceXLaunches(): Response<List<SpaceXItem>>
}