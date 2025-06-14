package com.example.finalassignment_1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {

    private val _loginResult = MutableSharedFlow<String>()
    val loginResult: SharedFlow<String> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                Log.d("LoginDebug", "Sending login request...")
                val response = authService.login(AuthRequest(username, password))
                Log.d("LoginDebug", "Login success: ${response.keypass}")
                _loginResult.emit(response.keypass)
            } catch (e: Exception) {
                Log.e("LoginDebug", "Login failed", e)
                _loginResult.emit("error")
            }
        }
    }
}