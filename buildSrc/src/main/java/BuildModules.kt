object BuildModules {

    const val APP = ":app"

    //:core
    private const val CORE = ":core"
    const val CORE_NETWORK = "$CORE:network"
    const val CORE_UI = "$CORE:ui"

    //:commons
    private const val COMMONS = ":commons"

    //:features
    private const val FEATURES = ":features"
    const val COLLECTION_DETAIL = "$FEATURES:collection_detail"

}