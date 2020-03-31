plugins {
    val kotlinVersion = "1.3.71"
    kotlin("jvm") version kotlinVersion apply false
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("js") version kotlinVersion apply false
}

subprojects {
    group = "plus.sourceplus"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}