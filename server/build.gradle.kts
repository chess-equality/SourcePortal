plugins {
    kotlin("jvm")
    application
}

application {
    mainClassName = "io.vertx.core.Launcher"
}

val mainVerticleName = "com.sourceplusplus.portal.server.PortalServer"

dependencies {
    val vertxVersion = "3.9.2"
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    implementation("com.apollographql.apollo:apollo-runtime:2.3.0")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.3.0")
    implementation("io.vertx:vertx-core:$vertxVersion")
    implementation("io.vertx:vertx-web:$vertxVersion")
    implementation("io.vertx:vertx-lang-kotlin:$vertxVersion")
    implementation("io.vertx:vertx-lang-kotlin-coroutines:$vertxVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    getByName<JavaExec>("run") {
        args = listOf("run", mainVerticleName)
    }
}