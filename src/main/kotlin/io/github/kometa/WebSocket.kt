package io.github.kometa

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

class WebSocket(port: Int = 8080) : WebSocketServer(InetSocketAddress(port)) {
    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        println("New connection from ${conn.remoteSocketAddress}")
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        println("Connection closed from ${conn.remoteSocketAddress} with exit code $code and reason: $reason")
    }

    override fun onMessage(conn: WebSocket, message: String) {
        println("Received message from ${conn.remoteSocketAddress}: $message")
        conn.send("Echo: $message") // Echo the message back to the client
    }

    override fun onError(conn: WebSocket?, ex: Exception) {
        println("An error occurred on connection ${conn?.remoteSocketAddress}: ${ex.message}")
    }

    override fun onStart() {
        println("WebSocket server started on port ${address.port}")
    }
}
