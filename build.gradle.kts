plugins {
    kotlin("jvm") version "1.9.22"
    application
//    id("org.jetbrains.compose") version "1.5.12"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val coroutines_version: String by project

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

application {
    mainClass.set("coroutines.MainKt")
    applicationDefaultJvmArgs  = listOf("-Dkotlinx.coroutines.debug")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

//    implementation(compose.desktop.currentOs)
}

//compose.desktop {
//    application {
//        mainClass = "MainKt"
//        nativeDistributions {
//            targetFormats(TargetFormat.Dmg)
//            packageName = "com.example"
//            packageVersion = "1.0.0"
//        }
//    }
//
//}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}
