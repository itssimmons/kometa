package io.github.kometrics

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private const val DELAY_TIME = 5L * 60 * 1000 // 5m in ms
private const val DELAY_TIME_TEST = 5L * 1000 // 5s in ms

fun main(): Unit = runBlocking {
    println("daemon started...")

    while (true) {
        println("Collecting metrics at: ${java.time.LocalDateTime.now()}")
        delay(DELAY_TIME_TEST)
    }
}
