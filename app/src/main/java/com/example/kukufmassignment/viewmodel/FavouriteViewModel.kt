package com.example.kukufmassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kukufmassignment.base.BaseViewModel
import com.example.kukufmassignment.model.SpaceXItem
import com.example.kukufmassignment.repo.FavouriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(repository: FavouriteRepository):
    BaseViewModel<FavouriteRepository>(repository) {

    private val _favouriteLaunches = MutableLiveData<List<SpaceXItem>>()
    val favouriteLaunches: LiveData<List<SpaceXItem>> = _favouriteLaunches

    fun getFavouriteLaunches() {
        viewModelScope.launch {
            val favouriteLaunches = getRepo().getFavouriteLaunches()
            _favouriteLaunches.value = favouriteLaunches
        }
    }
}