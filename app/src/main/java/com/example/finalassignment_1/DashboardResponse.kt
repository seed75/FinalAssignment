package com.example.finalassignment_1

data class DashboardResponse(
    val entities: List<Map<String, Any>>,
    val entityTotal: Int
)