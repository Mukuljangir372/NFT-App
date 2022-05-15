plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        multiDexEnabled = true
    }
    namespace = "com.mukul.jan.data"
}

dependencies {
    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB_JDK)

    //RETROFIT & GSON ----------------------------------------------------------------------------------------
    implementation(Libs.RETROFIT)
    implementation(Libs.GSON)

    //ROOM ----------------------------------------------------------------------------------------
    implementation(Libs.ROOM)
    annotationProcessor(Libs.ROOM_COMPILER)

    //PAGING ----------------------------------------------------------------------------------------
    implementation(Libs.PAGING_3)

    //MAP STRUCT ----------------------------------------------------------------------------------------
    implementation(Libs.MAP_STRUCT)
    kapt(Libs.MAP_STRUCT_PROCESS)

}