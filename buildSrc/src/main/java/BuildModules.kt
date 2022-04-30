object BuildModules {

    const val APP = ":app"

    //:core
    private const val CORE = ":core"
    const val CORE_NETWORK = "$CORE:network"
    const val CORE_UI = "$CORE:ui"

    //:commons
    private const val COMMONS = ":commons"
    const val COMMONS_VIEWS = "$COMMONS:views"
    const val COMMONS_MODELS = "$COMMONS:models"
}