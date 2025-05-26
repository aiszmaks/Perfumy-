plugins {
    kotlin("jvm") version "1.9.23"
    id("io.ktor.plugin") version "2.3.7"
    kotlin("plugin.serialization") version "1.9.23"
}

group = "pl.kowalczuk"
version = "1.0"

application {
    mainClass.set("pl.kowalczuk.perfumy.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.3.7")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.7")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    implementation("ch.qos.logback:logback-classic:1.4.11")
}