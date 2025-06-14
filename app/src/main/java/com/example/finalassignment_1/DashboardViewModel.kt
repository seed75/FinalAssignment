package com.example.finalassignment_1.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalassignment_1.DashboardItem
import com.example.finalassignment_1.api.DashboardService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardService: DashboardService
) : ViewModel() {

    private val _items = MutableStateFlow<List<Map<String, Any>>>(emptyList())
    val items: StateFlow<List<Map<String, Any>>> = _items

    fun loadItems(keypass: String) {
        viewModelScope.launch {
            try {
                Log.d("DashboardDebug", "Calling API with keypass: $keypass")
                val response = dashboardService.getItems(keypass)
                Log.d("DashboardDebug", "API returned: ${response.entities.size} items")
                _items.value = response.entities
            } catch (e: Exception) {
                Log.e("DashboardDebug", "Error fetching dashboard data", e)
            }
        }
    }
}
