package io.github.kometa.config

import com.typesafe.config.ConfigFactory

object Config {
    val config = ConfigFactory.load()

    val host = config.getString("server.host")
    val port = config.getInt("server.port")

    val pingInterval = config.getInt("websocket.pingInterval")
    val maxFrameSize = config.getInt("websocket.maxFrameSize")

    val logLevel = config.getString("logging.level")
    val logFile = config.getString("logging.file")
}
