package com.example.finalassignment_1

import org.junit.Assert.*
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitModuleTest {

    @Test
    fun `retrofit instance should not be null`() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://nit3213api.onrender.com/") // Replace real base URL
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        assertNotNull(retrofit)
    }

    @Test
    fun `retrofit base URL should be correct`() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://nit3213api.onrender.com/") // Replace real base URL
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        assertEquals("https://nit3213api.onrender.com/", retrofit.baseUrl().toString())
    }
}
