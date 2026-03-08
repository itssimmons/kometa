package io.github.kometa.websocket

import org.java_websocket.WebSocket

class MessageHandler {
    companion object {
        fun handle(conn: WebSocket, message: String) {
            println("Received message: $message")
        }
    }
}
