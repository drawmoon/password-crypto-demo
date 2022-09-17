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

		val stopWatch = StopWatch()

		stopWatch.start()
		val argon2EncodedStr = Argon2Crypto.encrypt(password)
		stopWatch.stop()

		println("Password: $password, encoded string: $argon2EncodedStr, Total time: ${stopWatch.totalTimeMillis}ms")

		stopWatch.start()
		val bCryptEncodedStr = BCrypto.encrypt(password)
		stopWatch.stop()

		println("Password: $password, encoded string: $bCryptEncodedStr, Total time: ${stopWatch.totalTimeMillis}ms")

		stopWatch.start()
		val sCryptEncodedStr = SCrypto.encrypt(password)
		stopWatch.stop()

		println("Password: $password, encoded string: $sCryptEncodedStr, Total time: ${stopWatch.totalTimeMillis}ms")
	}
}

fun main(args: Array<String>) {
	runApplication<PasswordCryptoDemoApplication>(*args)
}