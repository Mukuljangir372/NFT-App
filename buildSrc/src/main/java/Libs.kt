
object Libs {
    private val v = BuildDepVersions

    const val CORE_KTX = "androidx.core:core-ktx:${v.CORE_KTX}"
    const val KOTLIN_STDLIB_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${v.KOTLIN_STDLIB_JDK}"

    //JETPACK COMPOSE
    //-----------------------------------------------------------------------------------------------------
    const val COMPOSE_UI = "androidx.compose.ui:ui:${v.COMPOSE}"
    const val MATERIAL_COMPOSE = "androidx.compose.material:material:${v.COMPOSE}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${v.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${v.COMPOSE_ACTIVITY}"

    //-----------------------------------------------------------------------------------------------------
    //KTX
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${v.LIFECYCLE}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${v.LIFECYCLE}"

    //-----------------------------------------------------------------------------------------------------
    //KOTLIN COROUTINES
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${v.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${v.COROUTINES}"

    //-----------------------------------------------------------------------------------------------------
    //HILT
    const val HILT = "com.google.dagger:hilt-android:${v.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${v.HILT}"

    //-----------------------------------------------------------------------------------------------------
    //RETROFIT
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${v.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${v.RETROFIT}"
    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${v.OKHTTP}"


}





