package com.bharatanve.workoutappdemo.model

data class APIResponse(
    var `data`: Data? = null,
    var message: String? = null,
    var success: Boolean? = null
)