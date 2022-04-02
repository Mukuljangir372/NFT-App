
object TestLibs {
    private val v = BuildDepVersions

    //TEST -----------------------------------------------------------------------------------------------
    const val JUNIT = "junit:junit:${v.JUNIT}"

    //ANDROID TEST-----------------------------------------------------------------------------------------
    const val JUNIT_EXT_ANDROID = "androidx.test.ext:junit:${v.JUNIT_EXT_ANDROID}"
    const val EXPRESSO = "androidx.test.espresso:espresso-core:${v.EXPRESSO}"
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:${v.COMPOSE}"

    //DEBUG -----------------------------------------------------------------------------------------
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${v.COMPOSE}"

}