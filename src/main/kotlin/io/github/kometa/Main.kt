package io.github.kometa

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private const val DELAY_TIME = 5L * 1000 // 5s

fun main(): Unit = runBlocking {
    var tick: UInt = 0u
    while (true) {
        println("--- tick $tick ---")
        tick++;

        val hardware = Hardware()

        println("[CPU Info]")
        hardware.cpuInfo.apply {
            println("CPU Vendor: $vendorId")
            println("CPU Model: $modelName")
            println("CPU Cores: $cpuCores")
            println("CPU MHz: $cpuMHz\n")
        }

        println("[Memory Info]")
        hardware.memInfo.apply {
            println("Memory Total: ${memTotal / (1024 * 1024)} MB")
            println("Memory Free: ${memFree / (1024 * 1024)} MB")
            println("Memory Available: ${memAvailable / (1024 * 1024)} MB")
            println("Buffers: ${buffers / (1024 * 1024)} MB")
            println("Cached: ${cached / (1024 * 1024)} MB")
        }

        delay(DELAY_TIME)
    }
}
