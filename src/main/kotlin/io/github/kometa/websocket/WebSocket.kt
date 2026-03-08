package io.github.kometa.websocket

import io.github.kometa.models.Session

import java.net.InetSocketAddress
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer

class Server(port: UShort = 8080u) : WebSocketServer(InetSocketAddress(port.toInt())) {
    companion object {
        fun listen(port: UShort = 8080u) {
            println("Server listening at http://127.0.0.1:$port")
            Server(port).start()
        }
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        SessionManager.add(
            Session(
                sessionId = conn.hashCode().toString(),
                userAgent = handshake.getFieldValue("User-Agent"),
                ipAddress = conn.remoteSocketAddress.address.hostAddress,
                connectTime = System.currentTimeMillis(),
            )
        )
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        SessionManager.remove(conn) // Remove the connection from the session manager
        println("Connection closed from ${conn.remoteSocketAddress}")
    }

    override fun onMessage(conn: WebSocket, message: String) {
        MessageHandler.handle(conn, message) // Handle the incoming message using the message handler
    }

    override fun onError(conn: WebSocket?, ex: Exception) {
        println("An error occurred on connection ${conn?.remoteSocketAddress}: ${ex.message}")
    }

    override fun onStart() {
        println("Server started successfully")
    }
}
