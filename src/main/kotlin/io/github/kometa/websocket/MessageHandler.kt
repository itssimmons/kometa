package io.github.kometa.websocket

import io.github.kometa.domain.systeminfo.Hardware
import io.github.kometa.models.Message
import io.github.kometa.models.Ping
import io.github.kometa.models.Pong
import io.github.kometa.models.SysInfoResponse
import io.github.kometa.models.SysInfoRequest
import io.github.kometa.models.CpuInfo
import io.github.kometa.models.MemoryInfo
import io.github.kometa.models.SysInfoPayload

import kotlinx.serialization.json.Json
import org.java_websocket.WebSocket

class MessageHandler {
    companion object {
        private val json = Json {
            classDiscriminator = "type"
        }

        fun handle(conn: WebSocket, message: String) {
            try {
                when (val msg = json.decodeFromString<Message>(message)) {
                    is Ping -> {
                        conn.send(json.encodeToString(Pong("pong")))
                    }

                    is SysInfoRequest -> {
                        val hardware = Hardware()

                        val payload = SysInfoPayload(
                            cpu = CpuInfo(
                                vendorId = hardware.cpuInfo.vendorId,
                                modelName = hardware.cpuInfo.modelName,
                                cpuCores = hardware.cpuInfo.cpuCores,
                                cpuMHz = hardware.cpuInfo.cpuMHz
                            ),
                            memory = MemoryInfo(
                                buffers = hardware.memInfo.buffers,
                                cached = hardware.memInfo.cached,
                                free = hardware.memInfo.memFree,
                                total = hardware.memInfo.memAvailable,
                                memTotal = hardware.memInfo.memTotal
                            )
                        )

                        conn.send(
                            json.encodeToString(
                                SysInfoResponse(payload)
                            )
                        )
                    }

                    else -> {
                        println("Unknown message type: ${msg::class.simpleName}")
                    }
                }
            } catch (e: Exception) {
                println("Invalid message: $message")
                e.printStackTrace()
            }
        }
    }
}
