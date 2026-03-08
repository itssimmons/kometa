package io.github.kometa.domain.systeminfo

class CpuInfo {
    val vendorId: String
    val modelName: String
    val cpuCores: Int
    val cpuMHz: Double

    init {
        val cpuInfoFile = "/proc/cpuinfo"
        val lines = java.io.File(cpuInfoFile).readLines()
        vendorId = parseCpuInfo(lines, "vendor_id")
        modelName = parseCpuInfo(lines, "model name")
        cpuCores = parseCpuInfo(lines, "cpu cores").toIntOrNull() ?: 0
        cpuMHz = parseCpuInfo(lines, "cpu MHz").toDoubleOrNull() ?: 0.0
    }

    private fun parseCpuInfo(lines: List<String>, key: String): String {
        for (line in lines) {
            if (line.startsWith(key)) {
                return line.split(":")[1].trim()
            }
        }
        return ""
    }


}
