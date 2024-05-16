package com.example.activityfragments

import java.io.Serializable

data class Movie(
    val name: String,
    val description: String,
    val rate: Double,
    val director: String
) : Serializable
