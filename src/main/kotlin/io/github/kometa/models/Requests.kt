package io.github.kometa.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
@SerialName("ping")
data class Ping(
    val payload: Unit? = null
) : Message

@Serializable
@SerialName("sysinfo")
data class SysInfoRequest(
    val payload: Unit? = null
) : Message
