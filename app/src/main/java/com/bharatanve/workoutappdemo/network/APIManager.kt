package com.bharatanve.workoutappdemo.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bharatanve.workoutappdemo.model.APIResponse
import com.bharatanve.workoutappdemo.model.Section1
import com.bharatanve.workoutappdemo.repository.fakeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIManager {

    var HomeDataresponse : MutableState<APIResponse> = mutableStateOf(APIResponse())

    init {
        HomeDataresponse.value = fakeData
        getHomePageData()
    }

    fun getHomePageData() {
        val service = API.getHomeData

        service.getHomeData().enqueue(object : Callback<APIResponse> {
            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                Log.d("apidata", t.message.toString())
                HomeDataresponse.value = fakeData
            }

            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                HomeDataresponse.value.data = response.body()?.data
                HomeDataresponse.value.message = response.body()?.message
                HomeDataresponse.value.success = response.body()?.success

            }
        }
        )
    }
}