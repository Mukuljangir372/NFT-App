plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
}

dependencies {
    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB_JDK)
}