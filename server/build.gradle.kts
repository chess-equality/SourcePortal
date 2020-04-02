plugins {
    kotlin("jvm")
}
apply(plugin = "groovy")

dependencies {
    val VERTX_VERSION = "3.8.5"
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.codehaus.groovy:groovy-all:2.4.17")
    implementation("io.vertx:vertx-web:$VERTX_VERSION")
    implementation("io.vertx:vertx-tcp-eventbus-bridge:$VERTX_VERSION")
    implementation("com.github.sourceplusplus.assistant:source-api:master-SNAPSHOT")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.slf4j:slf4j-log4j12:1.7.30")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

/*
apply plugin: 'groovy'
apply plugin: 'application'

applicationName = 'source-portal'
archivesBaseName = 'source-portal'
mainClassName = 'com.sourceplusplus.portal.PortalBootstrap'

repositories {
    maven { url 'https://www.jetbrains.com/intellij-repository/snapshots/' }
    maven { url 'https://jetbrains.bintray.com/intellij-third-party-dependencies/' }
}
dependencies {
    implementation 'org.codehaus.groovy:groovy-all:2.4.17'
    compileOnly(group: 'com.jetbrains.intellij.platform', name: 'ide', version: '201.6073-EAP-CANDIDATE-SNAPSHOT') {
        transitive = false
    }
    compileOnly(group: 'com.jetbrains.intellij.platform', name: 'util', version: '201.6073-EAP-CANDIDATE-SNAPSHOT') {
        transitive = false
    }
    compileOnly 'org.jetbrains.intellij.deps.jcef:jcef:3.3683.1920.g9f41a27-3'
    implementation group: 'org.slf4j', name: 'slf4j-api', version: '1.7.30'
    implementation group: 'org.slf4j', name: 'slf4j-log4j12', version: '1.7.30'
    implementation "io.vertx:vertx-web:$VERTX_VERSION"
    implementation "io.vertx:vertx-tcp-eventbus-bridge:$VERTX_VERSION"
    implementation project(":api")
}

task createProperties(dependsOn: processResources) {
    doLast {
        new File("$buildDir/resources/main/source-portal_build.properties").withWriter { w ->
            Properties p = new Properties()
            p['version'] = project.version.toString()
            p['build_date'] = new Date().toInstant().toString()
            p.store w, null
        }
    }
}
classes {
    dependsOn createProperties
}
 */