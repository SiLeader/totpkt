plugins {
    kotlin("jvm") version "2.0.0"
}

group = "net.sileader"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-datetime", version = "0.6.0")
    implementation(group = "commons-codec", name = "commons-codec", version = "1.17.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}