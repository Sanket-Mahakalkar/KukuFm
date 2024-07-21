package com.example.kukufmassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kukufmassignment.base.BaseViewModel
import com.example.kukufmassignment.data.network.Resource
import com.example.kukufmassignment.model.SpaceXItem
import com.example.kukufmassignment.repo.SpaceXLaunchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class SpaceXLaunchViewModel @Inject constructor(repository: SpaceXLaunchRepository)
    : BaseViewModel<SpaceXLaunchRepository>(repository) {

    private val _spaceXLaunchesResult = MutableLiveData<Resource<List<SpaceXItem>>>()
    val spaceXLaunchesResult: LiveData<Resource<List<SpaceXItem>>> = _spaceXLaunchesResult


    fun getSpaceXLaunches() {
        _spaceXLaunchesResult.value = Resource.loading(null)
        viewModelScope.launch {
            supervisorScope {

                val apiResponseDeferred = async { getRepo().getSpaceXLaunches() }
                val localDataDeferred = async { getRepo().getSpaceXLaunchesFromDb() }

                val apiResult = try {
                    val response = apiResponseDeferred.await()
                    if (response.isSuccessful) {
                        response.body()
                    } else {
                        emptyList()
                    }
                } catch (e: Exception) {
                    emptyList()
                }

                val localData = try {
                    localDataDeferred.await()
                } catch (e: Exception) {
                    emptyList()
                }

                val mergeResult = getRepo().mergeWithLocalData(apiResult, localData)
                if(mergeResult.isNotEmpty()){
                    _spaceXLaunchesResult.value = Resource.success(mergeResult)
                    storeSpaceXLaunchesInDb(mergeResult)
                }else {
                    _spaceXLaunchesResult.value = Resource.error(
                        null, "Something went wrong. Please check your internet connection")
                }

            }
        }
    }


    private suspend fun storeSpaceXLaunchesInDb(result: List<SpaceXItem>?) {
        getRepo().storeSpaceXLaunchesInDb(result)
    }

    suspend fun searchSpaceXLaunches(query: String) {
        val result = getRepo().searchSpaceXLaunches(query)
        _spaceXLaunchesResult.value = Resource.success(result)
    }

    fun updateSpaceXLaunchesInDb(spaceXItem: SpaceXItem) {
        viewModelScope.launch {
            getRepo().updateSpaceXLaunchesInDb(spaceXItem)
        }
    }
}