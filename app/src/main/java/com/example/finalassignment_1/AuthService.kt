package com.example.finalassignment_1

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("sydney/auth")
    suspend fun login(@Body request: AuthRequest): AuthResponse
}