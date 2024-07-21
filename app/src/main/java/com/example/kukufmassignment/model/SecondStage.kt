package com.example.kukufmassignment.model

import java.io.Serializable

data class SecondStage(
    val block: Int?,
    val payloads: List<Payload?>?
): Serializable