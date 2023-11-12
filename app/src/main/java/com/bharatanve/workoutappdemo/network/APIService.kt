package com.bharatanve.workoutappdemo.network

import com.bharatanve.workoutappdemo.model.APIResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("homepage_v2/?format=json")
    fun getHomeData() : Call<APIResponse>
}