package com.example.kukufmassignment.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kukufmassignment.dispatcher.IDispatcherProvider

open class BaseViewModel<R: BaseRepository>(
    private val repository: R,
    ): ViewModel(){

        fun getRepo() = repository



}