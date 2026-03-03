package io.github.kometa

class Hardware {
    val cpuInfo: CpuInfo
    val memInfo: MemInfo

    init {
        cpuInfo = CpuInfo()
        memInfo = MemInfo()
    }
}
