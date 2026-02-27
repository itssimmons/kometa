plugins {
    kotlin("jvm") version "2.1.0"
    id("com.gradleup.shadow") version "9.3.2"
}

group = "io.github.kometrics"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        manifest {
            attributes["Main-Class"] = "io.github.kometrics.MainKt"
        }
        mergeServiceFiles()
    }

    build {
        dependsOn(shadowJar)
    }
}
