package com.example.passwordcryptodemo.scrypt

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder

// Dependencies:

// implementation("org.springframework.security:spring-security-crypto:5.7.3")
// implementation("org.bouncycastle:bcprov-jdk15on:1.70")

object SCrypto {

    private val encoder = SCryptPasswordEncoder()

    fun encrypt(password: String): String {

        return encoder.encode(password)
    }
}