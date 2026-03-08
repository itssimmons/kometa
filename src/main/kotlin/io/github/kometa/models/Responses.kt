package io.github.kometa.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
@SerialName("pong")
data class Pong(
    val payload: String? = null
) : Message

@Serializable
@SerialName("sysinfo_response")
data class SysInfoResponse(
    val payload: SysInfoPayload
) : Message
