package com.example.kukufmassignment.model

import java.io.Serializable

data class LaunchFailureDetails(
    val altitude: Int?,
    val reason: String?,
    val time: Int?
): Serializable