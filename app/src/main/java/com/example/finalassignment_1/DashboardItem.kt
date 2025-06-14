package com.example.finalassignment_1

data class DashboardItem(
    val assetType: String? = null,
    val ticker: String? = null,
    val currentPrice: Double? = null,
    val dividendYield: Double? = null,
    val description: String? = null,

    // Alternative fields to support other students' data structures
    val name: String? = null,
    val email: String? = null
)