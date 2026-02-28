package io.github.kometa

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private const val DELAY_TIME = 5L * 1000 // 5s

fun main(): Unit = runBlocking {
    println("daemon started...")

    while (true) {
        println("Collecting metrics at: ${java.time.LocalDateTime.now()}")
        delay(DELAY_TIME)
    }
}
