package io.github.kometa.config

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config as TypesafeConfig

object Config {
    val config: TypesafeConfig = ConfigFactory.load()

    val host: String = config.getString("server.host")
    val port: Int = config.getInt("server.port")

    val pingInterval: Int = config.getInt("websocket.pingInterval")
    val maxFrameSize: Int = config.getInt("websocket.maxFrameSize")

    val logLevel: String = config.getString("logging.level")
    val logFile: String = config.getString("logging.file")
}
