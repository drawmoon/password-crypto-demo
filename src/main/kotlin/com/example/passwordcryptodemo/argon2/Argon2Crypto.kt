package com.example.passwordcryptodemo.argon2

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

// Dependencies:

// implementation("org.springframework.security:spring-security-crypto:5.7.3")
// implementation("org.bouncycastle:bcprov-jdk15on:1.70")


// Argon2d：最大限度地抵抗 GPU 破解攻击，适用于加密货币。
// Argon2i：优化抵御侧通道攻击，适合密码哈希。
// Argon2id：混合版本，如果不确定，选择这个。

object Argon2Crypto {

    // 变体 = argon2id
    // Salt = 16字节，128位
    // 散列长度 = 32字节，256位
    // 迭代 = 10
    // 记忆 = 1 < 16，或2 ^ 16,65536k，64M
    // 并行性 = 1

    private val encoder = Argon2PasswordEncoder(16, 32, 1, 65536, 10)

    fun encrypt(password: String): String {

        return encoder.encode(password)
    }
}