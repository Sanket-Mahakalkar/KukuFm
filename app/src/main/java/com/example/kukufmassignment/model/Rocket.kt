package com.example.kukufmassignment.model

import java.io.Serializable

data class Rocket(
    val fairings: Fairings?,
    val first_stage: FirstStage?,
    val rocket_id: String?,
    val rocket_name: String?,
    val rocket_type: String?,
    val second_stage: SecondStage?
): Serializable