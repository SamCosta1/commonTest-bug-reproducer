
plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    id("org.jetbrains.compose").version("1.5.3") apply false
}

buildscript {
    dependencies {
        classpath(":build-logic")
    }
}

allprojects {
    group = "com.example"
    version = "0.0.0"

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}


tasks.withType<Test> {
    maxParallelForks = 0
}