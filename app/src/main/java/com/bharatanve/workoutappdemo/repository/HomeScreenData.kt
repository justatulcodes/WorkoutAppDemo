package com.bharatanve.workoutappdemo.repository

import com.bharatanve.workoutappdemo.model.APIResponse
import com.bharatanve.workoutappdemo.network.APIManager


fun getHomeScreenData() : APIResponse {

    return if (APIManager().HomeDataresponse.value.success != null) {
        APIManager().HomeDataresponse.value
    }
    else fakeData
}