plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
    namespace = "com.mukul.jan.domain"

    defaultConfig {
        multiDexEnabled = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildDepVersions.COMPOSE
    }
}

dependencies {

    //MODULES --------------------------------------------------------------------------------------
    implementation(project(BuildModules.DATA_ANDROID))

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB_JDK)

    //COMPOSE --------------------------------------------------------------------------------------
    implementation(Libs.PAGING_3)

    //HILT ----------------------------------------------------------------------------------------
    implementation(Libs.HILT)
    implementation(Libs.HILT_COMPOSE_NAV)
    kapt(Libs.HILT_COMPILER)

    //KTX ----------------------------------------------------------------------------------------
    implementation(Libs.LIFECYCLE_KTX)
    implementation(Libs.VIEWMODEL_KTX)

}


kapt {
    correctErrorTypes = true
}
