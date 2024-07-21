package com.example.kukufmassignment.data.network

class Resource<T> (val status: Status, val data: T?, val message: String? = null) {

    companion object {

        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> error(data: T?, message: String?) = Resource(Status.ERROR, data, message)

        fun <T> loading(data: T?) = Resource(Status.LOADING, data)
    }
}

enum class Status{
    SUCCESS,
    ERROR,
    LOADING
}