package io.github.kometa.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class CpuInfo(
    val vendorId: String,
    val modelName: String,
    val cpuCores: Int,
    val cpuMHz: Double
)

@Serializable
data class MemoryInfo(
    val buffers: Long,
    val cached: Long,
    val free: Long,
    val total: Long,
    val memTotal: Long
)

@Serializable
data class SysInfoPayload(
    val cpu: CpuInfo,
    val memory: MemoryInfo
)
