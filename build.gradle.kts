plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.serialization") version "2.3.10"
    id("com.gradleup.shadow") version "9.3.2"
}

group = "io.github.kometa"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.10.0")
    implementation("org.java-websocket:Java-WebSocket:1.6.0")
    implementation("com.typesafe:config:1.4.4")
}

tasks.shadowJar {
    archiveClassifier.set("")
    mergeServiceFiles()
    manifest {
        attributes["Main-Class"] = "io.github.kometa.MainKt"
    }
}

tasks.register<Exec>("run") {
    dependsOn(tasks.shadowJar)
    commandLine("java", "-jar", tasks.shadowJar.get().archiveFile.get().asFile.absolutePath)
}
