plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "AdventOfCode"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
include("src:advent2022")
findProject(":src:advent2022")?.name = "advent2022"
include("src:advent2023")
findProject(":src:advent2023")?.name = "advent2023"
include("src:advent2024")
findProject(":src:advent2024")?.name = "advent2024"
include("src:common")
findProject(":src:common")?.name = "common"
