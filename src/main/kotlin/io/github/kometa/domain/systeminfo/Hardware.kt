package io.github.kometa.domain.systeminfo

class Hardware {
    val cpuInfo: CpuInfo
    val memInfo: MemInfo

    init {
        cpuInfo = CpuInfo()
        memInfo = MemInfo()
    }
}
