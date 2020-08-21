plugins {
    kotlin("js")
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
        val main by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation(project(":shared"))
                implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
            }
        }
    }
}