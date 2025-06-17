package com.example.finalassignment_1

import org.junit.Assert.*
import org.junit.Test

class LoginRequestTest {
    @Test
    fun `login request fields should be set correctly`() {
        val request = AuthRequest("john", "secret123")
        assertEquals("john", request.username)
        assertEquals("secret123", request.password)
    }
}
