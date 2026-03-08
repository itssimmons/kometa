package io.github.kometa

import io.github.kometa.websocket.Server as WebSocket

fun main() {
    WebSocket.listen(8080u)
}
