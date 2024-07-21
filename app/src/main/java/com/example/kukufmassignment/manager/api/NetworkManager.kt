package com.example.kukufmassignment.manager.api

import com.example.kukufmassignment.data.network.ServiceGenerator
import com.example.kukufmassignment.model.SpaceXItem
import retrofit2.Response
import javax.inject.Inject

class NetworkManager @Inject constructor(): INetworkManager{

    override suspend fun getSpaceXLaunches(): Response<List<SpaceXItem>> {
        return ServiceGenerator.getApiService().getSpaceXLaunches()
    }
}