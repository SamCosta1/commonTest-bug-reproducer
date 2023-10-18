pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "common-test-reproduction"
includeBuild("build-logic")
include(":test-ui-module")
include(":test-ui-module:desktop")
include(":test-ui-module:common")
include(":test-ui-module:android")
