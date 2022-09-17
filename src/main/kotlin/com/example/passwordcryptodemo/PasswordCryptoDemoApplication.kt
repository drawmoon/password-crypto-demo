package com.example.passwordcryptodemo

import com.example.passwordcryptodemo.argon2.Argon2Crypto
import com.example.passwordcryptodemo.bcrypt.BCrypto
import com.example.passwordcryptodemo.scrypt.SCrypto
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.util.StopWatch

@SpringBootApplication
class PasswordCryptoDemoApplication : CommandLineRunner {

	private val password = "8UApxSY@awua"

	override fun run(vararg args: String?) {

		println("Original password: $password")

		// Argon2
		val argon2CryptoStopWatch = StopWatch()
		argon2CryptoStopWatch.start()

		val argon2EncodedStr = Argon2Crypto.encrypt(password)

		argon2CryptoStopWatch.stop()

		println("Crypto algorithm: Argon2, encode result: $argon2EncodedStr, total time: ${argon2CryptoStopWatch.totalTimeMillis}ms")

		// BCrypt
		val bCryptoStopWatch = StopWatch()
		bCryptoStopWatch.start()

		val bCryptoEncodedStr = BCrypto.encrypt(password)

		bCryptoStopWatch.stop()

		println("Crypto algorithm: BCrypt, encode result: $bCryptoEncodedStr, total time: ${bCryptoStopWatch.totalTimeMillis}ms")

		// SCrypt
		val sCryptoStopWatch = StopWatch()
		sCryptoStopWatch.start()

		val sCryptoEncodedStr = SCrypto.encrypt(password)

		sCryptoStopWatch.stop()

		println("Crypto algorithm: SCrypt, encode result: $sCryptoEncodedStr, total time: ${sCryptoStopWatch.totalTimeMillis}ms")
	}
}

fun main(args: Array<String>) {
	runApplication<PasswordCryptoDemoApplication>(*args)
}