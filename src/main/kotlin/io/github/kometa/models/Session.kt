package io.github.kometa.models

import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val sessionId: String,
    val userAgent: String,
    val ipAddress: String,
    val connectTime: Long,
)
