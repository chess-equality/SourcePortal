plugins {
    kotlin("js")
}

kotlin {
    js {
        useCommonJs()
        browser()
        binaries.executable()
    }

    sourceSets {
        val main by getting {
            dependencies {
//                implementation(npm("echarts", "4.8.0", generateExternals = true))
//                implementation(npm("fomantic-ui-less", "2.8.6"))
//                implementation(npm("sockjs-client", "1.4.0", generateExternals = true))
//                implementation(npm("vertx3-eventbus-client", "3.9.1", generateExternals = true))
//                implementation(npm("jquery", "3.5.1", generateExternals = true))

                implementation(kotlin("stdlib-js"))
                implementation(project(":shared"))
                implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
            }
        }
    }
}