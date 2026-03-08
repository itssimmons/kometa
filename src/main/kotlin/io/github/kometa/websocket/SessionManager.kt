package io.github.kometa.websocket

import io.github.kometa.models.Session

import org.java_websocket.WebSocket
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import java.io.File

class SessionManager {
    companion object {
        fun get(websocket: WebSocket): Session {
            val sessionId = websocket.hashCode().toString()
            val filename = "sessions/${sessionId.take(2)}/${sessionId}.session"
            val file = File(filename)
            if (!file.exists()) {
                throw IllegalArgumentException("Session not found: $sessionId")
            }
            val content = file.readText()
            return Json.decodeFromString<Session>(content)
        }

        fun add(session: Session) {
            val sessionId = session.sessionId
            val prefix = "sessions/${sessionId.take(2)}"
            File(prefix).mkdirs()
            var filename = "${sessionId}.session"
            val json = Json { prettyPrint = true }
            File("$prefix/$filename").writeText(
                Json.encodeToString<Session>(session)
            )
        }

        fun remove(websocket: WebSocket) {
            val sessionId = websocket.hashCode().toString()
            val filename = "sessions/${sessionId.take(2)}/${sessionId}.session"
            val file = File(filename)
            if (file.exists()) {
                file.delete()
            }
        }
    }
}
