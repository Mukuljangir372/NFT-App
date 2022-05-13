@file:Suppress("DEPRECATION")

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        multiDexEnabled = true
    }

    namespace = "com.mukul.jan.ui"

    composeOptions {
        kotlinCompilerVersion = BuildDepVersions.COMPOSE_COMPILER
        kotlinCompilerExtensionVersion = BuildDepVersions.COMPOSE
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB_JDK)

    //COMPOSE --------------------------------------------------------------------------------------
    implementation(Libs.MATERIAL_COMPOSE)
    implementation(Libs.COMPOSE_UI)
    implementation(Libs.COMPOSE_PREVIEW)
}