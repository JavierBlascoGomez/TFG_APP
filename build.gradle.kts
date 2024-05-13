// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false

    id("org.jetbrains.kotlin.android") version "1.9.20" apply false

    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}

buildscript {
    dependencies {
        val hiltVersion = "2.48.1" // Reemplazar con la versión más reciente
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}