plugins {
    kotlin("js")
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