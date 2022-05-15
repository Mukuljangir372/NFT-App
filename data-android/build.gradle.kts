plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        multiDexEnabled = true
    }

    namespace = "com.mukul.jan.data_android"
}

dependencies {
    //MODULES --------------------------------------------------------------------------------------
    api(project(BuildModules.DATA))

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB_JDK)

    //ROOM & PAGING ----------------------------------------------------------------------------------------
    implementation(Libs.ROOM)
    implementation(Libs.ROOM_PAGING)
    implementation(Libs.PAGING_3)
    kapt(Libs.ROOM_COMPILER)

    //HILT ----------------------------------------------------------------------------------------
    implementation(Libs.HILT)
    implementation(Libs.HILT_COMPOSE_NAV)
    kapt(Libs.HILT_COMPILER)

    //MAP STRUCT ----------------------------------------------------------------------------------------
    implementation(Libs.MAP_STRUCT)
    kapt(Libs.MAP_STRUCT_PROCESS)

    //COROUTINES ----------------------------------------------------------------------------------------
    implementation(Libs.COROUTINES_ANDROID)

    //RETROFIT & GSON ----------------------------------------------------------------------------------------
    implementation(Libs.RETROFIT)
    implementation(Libs.GSON)
}

kapt {
    correctErrorTypes = true
}
