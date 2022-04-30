
plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
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

    //HILT ----------------------------------------------------------------------------------------
    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)

    //KTX ----------------------------------------------------------------------------------------
    implementation(Libs.LIFECYCLE_KTX)
    implementation(Libs.VIEWMODEL_KTX)

}

kapt {
    correctErrorTypes = true
}
