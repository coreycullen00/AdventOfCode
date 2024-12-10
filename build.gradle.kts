plugins {
    kotlin("jvm") version "2.1.0"
    id("com.diffplug.spotless") version "6.0.0"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        ktlint("0.41.0").userData(mapOf("indent_size" to "4", "continuation_indent_size" to "4"))
    }
}
