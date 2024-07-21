package com.example.kukufmassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kukufmassignment.base.BaseViewModel
import com.example.kukufmassignment.data.network.Resource
import com.example.kukufmassignment.dispatcher.IDispatcherProvider
import com.example.kukufmassignment.model.SpaceXItem
import com.example.kukufmassignment.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: MainRepository
) : BaseViewModel<MainRepository>(repository) {

}