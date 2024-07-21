package com.example.kukufmassignment.model

import java.io.Serializable

data class Fairings(
    val recovered: Boolean?,
    val recovery_attempt: Boolean?,
    val reused: Boolean?,
    val ship: String?
): Serializable