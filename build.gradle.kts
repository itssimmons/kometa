plugins {
    kotlin("jvm") version "2.1.0"
    id("com.gradleup.shadow") version "9.3.2"
}

group = "io.github.kometa"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
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
