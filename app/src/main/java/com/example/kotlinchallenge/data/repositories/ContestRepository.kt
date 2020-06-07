package com.example.kotlinchallenge.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinchallenge.data.network.CodeChefApi
import com.example.kotlinchallenge.data.network.responses.ArrayDataResponse
import com.example.kotlinchallenge.data.network.responses.DataResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Venkhatesh on 02-06-2020.
 */
class ContestRepository {
    val TAG:String = "ContestRepository"

    suspend fun fetchOngoingContest(): List<ArrayDataResponse>?{
        val ongoingResponse = CodeChefApi.invoke().onGoing()
        return ongoingResponse.body()?.Data
    }

    suspend fun fetchUpcomingContest(): List<ArrayDataResponse>? {
        val result = CodeChefApi.invoke().upComing()
        val apiResponse = MutableLiveData<List<ArrayDataResponse>>()
        //apiResponse.value = result.body()?.Data
        return result.body()?.Data
    }
}