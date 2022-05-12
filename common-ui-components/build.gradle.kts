plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        multiDexEnabled = true
    }
    namespace = "com.mukul.jan.common_ui_components"
}

dependencies {
    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB_JDK)
}