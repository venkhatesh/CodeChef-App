package com.example.kotlinchallenge.data.network

import com.example.kotlinchallenge.data.network.responses.DataResponse
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Venkhatesh on 02-06-2020.
 */
interface CodeChefApi {

    @GET("ongoing")
    suspend fun onGoing(): Response<DataResponse>

    @GET("future")
    suspend fun upComing(): Response<DataResponse>

    @GET("past")
    suspend fun past() : Response<DataResponse>

    companion object{

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(60,java.util.concurrent.TimeUnit.SECONDS)
            .build()


        operator fun invoke() : CodeChefApi {
            return Retrofit.Builder()
                .baseUrl("http://intense-citadel-99793.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(CodeChefApi::class.java)
        }
    }
}