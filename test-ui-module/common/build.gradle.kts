import com.example.AndroidConfig
import com.example.JavaConfig

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.compose)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget()
    jvm("desktop") {
        jvmToolchain(JavaConfig.toolchain)
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                /* Compose */
                implementation(compose.runtime)
                implementation(compose.material3)
                implementation(compose.preview)

                /* Coroutines */
                implementation(libs.kotlinx.coroutines.core)

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                /* Compose */
                implementation(libs.androidx.compose.ui)
                implementation(libs.androidx.compose.activity)
                implementation(libs.androidx.compose.uiToolingPreview)
                implementation(libs.androidx.lifecycleRuntimeKtx)
            }
        }
        val androidUnitTest by getting
        val desktopMain by getting {
            dependencies {
                /* Compose */
                implementation(compose.desktop.currentOs) {
                    exclude("org.jetbrains.compose.material")
                }

                /* Coroutines */
                implementation(libs.kotlinx.coroutines.swing)

            }
        }
        val desktopTest by getting
    }
}

android {
    namespace = group.toString()
    compileSdk = AndroidConfig.targetSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }
    compileOptions {
        sourceCompatibility = JavaConfig.version
        targetCompatibility = JavaConfig.version
    }
}