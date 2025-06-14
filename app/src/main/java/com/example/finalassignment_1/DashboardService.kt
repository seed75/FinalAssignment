package com.example.finalassignment_1.api

import com.example.finalassignment_1.DashboardResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DashboardService {
    @GET("dashboard/{keypass}")
    suspend fun getItems(@Path("keypass") keypass: String): DashboardResponse
}