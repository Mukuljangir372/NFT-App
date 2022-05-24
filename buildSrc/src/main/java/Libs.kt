
object Libs {
    private val v = BuildDepVersions

    const val CORE_KTX = "androidx.core:core-ktx:${v.CORE_KTX}"
    const val KOTLIN_STDLIB_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${v.KOTLIN_STDLIB_JDK}"

    //JETPACK COMPOSE
    //-----------------------------------------------------------------------------------------------------
    const val COMPOSE_UI = "androidx.compose.ui:ui:${v.COMPOSE}"
    const val MATERIAL_COMPOSE = "androidx.compose.material:material:${v.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${v.COMPOSE}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${v.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${v.COMPOSE_ACTIVITY}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${v.COMPOSE}"
    const val COMPOSE_NAV_ANIM = "com.google.accompanist:accompanist-navigation-animation:${v.COMPOSE_NAV_ANIM}"

    //PAGING
    const val PAGING_3 = "androidx.paging:paging-compose:${v.PAGING}"

    //COIL (IMAGE LOADING)
    const val COIL_ACCOMPANIST = "com.google.accompanist:accompanist-coil:${v.COIL_ACCOMPANIST}"
    const val COIL = "io.coil-kt:coil-compose:${v.COIL}"

    //-----------------------------------------------------------------------------------------------------
    //KTX
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${v.LIFECYCLE}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${v.LIFECYCLE}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${v.LIFECYCLE}"
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${v.LIFECYCLE}"
    const val LIFECYCLE_EXTS = "androidx.lifecycle:lifecycle-extensions:${v.LIFECYCLE_EXTS}"
    const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${v.LIFECYCLE}"

    //-----------------------------------------------------------------------------------------------------
    //KOTLIN COROUTINES
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${v.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${v.COROUTINES}"

    //-----------------------------------------------------------------------------------------------------
    //STORE (local + network cache)
    const val STORE_DROPBOX = "com.dropbox.mobile.store:store4:${v.STORE_DROPBOX}"

    //-----------------------------------------------------------------------------------------------------
    //HILT
    const val HILT = "com.google.dagger:hilt-android:${v.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${v.HILT}"
    const val HILT_COMPOSE_NAV = "androidx.hilt:hilt-navigation-compose:${v.HILT_COMPOSE}"

    //-----------------------------------------------------------------------------------------------------
    //RETROFIT
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${v.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${v.RETROFIT}"

    //-----------------------------------------------------------------------------------------------------
    //OKHTTP
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${v.OKHTTP}"
    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${v.OKHTTP}"

    //-----------------------------------------------------------------------------------------------------
    //GSON
    const val GSON = "com.google.code.gson:gson:${v.GSON}"

    //-----------------------------------------------------------------------------------------------------
    //MULTI DEX SUPPORT
    const val MULTIDEX = "com.android.support:multidex:${v.MULTIDEX}"

    //-----------------------------------------------------------------------------------------------------
    //ROOM DATABASE
    const val ROOM = "androidx.room:room-runtime:${v.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${v.ROOM}"
    const val ROOM_TESTING = "androidx.room:room-testing:${v.ROOM}"
    const val ROOM_PAGING = "androidx.room:room-paging:${v.ROOM}"

    //-----------------------------------------------------------------------------------------------------
    //MAP STRUCT
    const val MAP_STRUCT = "org.mapstruct:mapstruct:${v.MAP_STRUCT}"
    const val MAP_STRUCT_PROCESS = "org.mapstruct:mapstruct-processor:${v.MAP_STRUCT}"


}



















