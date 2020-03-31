plugins {
    id("org.jetbrains.kotlin.js") version "1.3.71"
}

kotlin {
    target {
        browser()
    }
    sourceSets {
        val main by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation(project(":shared"))
            }
        }
    }
}