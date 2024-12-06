plugins {
    kotlin("jvm") version "1.9.20"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        kotlin.srcDir("sol")
    }
}

dependencies {
    implementation(project(":src:common"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}