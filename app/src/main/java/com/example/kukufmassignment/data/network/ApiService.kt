package com.example.kukufmassignment.data.network

import com.example.kukufmassignment.model.SpaceXItem
import com.example.kukufmassignment.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(AppConstants.ApiEndPoint.GET_LAUNCHES)
    suspend fun getSpaceXLaunches(): Response<List<SpaceXItem>>
}