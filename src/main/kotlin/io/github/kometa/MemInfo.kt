package io.github.kometa

class MemInfo {
    val memTotal: Long
    val memFree: Long
    val memAvailable: Long
    val buffers: Long
    val cached: Long

    init {
        val memInfoFile = "/proc/meminfo"
        val lines = java.io.File(memInfoFile).readLines()
        memTotal = parseMemInfo(lines, "MemTotal")
        memFree = parseMemInfo(lines, "MemFree")
        memAvailable = parseMemInfo(lines, "MemAvailable")
        buffers = parseMemInfo(lines, "Buffers")
        cached = parseMemInfo(lines, "Cached")
    }

    private fun parseMemInfo(lines: List<String>, key: String): Long {
        for (line in lines) {
            if (line.startsWith(key)) {
                return line.split(Regex("\\s+"))[1].toLong() * 1024 // Convert from kB to bytes
            }
        }
        return 0L
    }
}
