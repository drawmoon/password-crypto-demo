package com.example.passwordcryptodemo.bcrypt

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


// Dependencies:

// implementation("org.springframework.security:spring-security-crypto:5.7.3")
// implementation("org.bouncycastle:bcprov-jdk15on:1.70")

object BCrypto {

    private val encoder = BCryptPasswordEncoder()

    fun encrypt(password: String): String {

        return encoder.encode(password)
    }
}