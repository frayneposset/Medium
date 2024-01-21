plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("io.freefair.lombok") version "8.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    val kotestVersion : String by project
    val coVersion : String by project
    val junitVersion : String by project
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$coVersion")
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
    testImplementation ("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}

application {
    mainClass.set("MainKt")
}