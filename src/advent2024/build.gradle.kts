plugins {
    kotlin("jvm") version "2.1.0"
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