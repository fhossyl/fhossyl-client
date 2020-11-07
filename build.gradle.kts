@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}

allprojects {

    plugins.apply("org.jetbrains.kotlin.multiplatform")
    plugins.apply("org.jetbrains.kotlin.plugin.serialization")

    repositories {
        mavenCentral()
        jcenter()
    }

    kotlin {

        jvm {
            compilations.all {
                kotlinOptions.jvmTarget = "1.8"
            }
            testRuns["test"].executionTask.configure {
                useJUnitPlatform()
            }
        }

        linuxX64()

        val hostOs = System.getProperty("os.name")
        val isMingwX64 = hostOs.startsWith("Windows")

        val nativeTarget = when {
            hostOs == "Mac OS X" -> macosX64("native")
            hostOs == "Linux" -> linuxX64("native")
            isMingwX64 -> mingwX64("native")
            else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
        }

        js {
            nodejs {
                binaries.executable()
            }
        }

        sourceSets {
            val commonMain by getting {
                dependencies {
                    api(project(":packets:bedrock-edition"))
                    api(project(":packets:java-edition"))
                    api(project(":packets:common"))
                    implementation("io.ktor:ktor-io:1.4.1")
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
                    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
                }
            }
            val commonTest by getting {
                dependencies {
                    implementation(kotlin("test-common"))
                    implementation(kotlin("test-annotations-common"))
                }
            }
            val jvmMain by getting
            val jvmTest by getting {
                dependencies {
                    implementation(kotlin("test-junit5"))
                    implementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
                    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
                }
            }
            val linuxX64Main by getting
            val linuxX64Test by getting
            val nativeMain by getting
            val nativeTest by getting
            val jsMain by getting
            val jsTest by getting
        }

    }

}
