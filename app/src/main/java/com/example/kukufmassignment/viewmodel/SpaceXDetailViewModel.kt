package com.example.kukufmassignment.viewmodel

import com.example.kukufmassignment.base.BaseRepository
import com.example.kukufmassignment.base.BaseViewModel
import com.example.kukufmassignment.repo.SpaceXDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpaceXDetailViewModel @Inject constructor(repository: SpaceXDetailRepository)
    : BaseViewModel<SpaceXDetailRepository>(repository) {
}