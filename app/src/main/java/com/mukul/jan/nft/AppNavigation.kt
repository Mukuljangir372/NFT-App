package com.mukul.jan.nft

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mukul.jan.ui_asset_detail.AssetDetail
import com.mukul.jan.ui_collection_detail.CollectionDetail
import com.mukul.jan.ui_collections_list.CollectionList
import com.mukul.jan.ui_saved_assets.SavedAssets
import com.mukul.jan.ui_saved_collections.SavedCollections

internal sealed class Screen(val route: String) {
    object Collection : Screen("collection")
    object SavedCollections : Screen("savedCollections")
    object SavedAssets : Screen("savedAssets")
}

private sealed class NavScreen(
    private val route: String
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object Collection : NavScreen("collection")
    object SavedCollections : NavScreen("savedCollections")
    object SavedAssets : NavScreen("savedAssets")

    object CollectionDetail : NavScreen("collectionDetail/{collectionId}") {
        fun createRoute(root: Screen, collectionId: String): String {
            return "${root.route}/collectionDetail/{$collectionId}"
        }
    }

    object AssetDetail : NavScreen("assetDetail/{assetId}") {
        fun createRoute(root: Screen, assetId: String): String {
            return "${root.route}/assetDetail/{$assetId}"
        }
    }

}

//-----------------------------------------------------------------------------------------------------
//Nav Graphs

@Composable
internal fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Collection.route
    ) {
        addCollectionTopLevel(navController)
        addSavedCollectionsTopLevel(navController)
        addSavedAssetsTopLevel(navController)
    }
}

private fun NavGraphBuilder.addCollectionTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Screen.Collection.route,
        startDestination = NavScreen.Collection.createRoute(Screen.Collection)
    ) {
        addCollection(navController, Screen.Collection)
        addCollectionDetail(navController, Screen.Collection)
    }
}

private fun NavGraphBuilder.addSavedCollectionsTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Screen.SavedCollections.route,
        startDestination = NavScreen.SavedCollections.createRoute(Screen.SavedCollections)
    ) {
        addSavedCollections(navController, Screen.SavedCollections)
    }
}

private fun NavGraphBuilder.addSavedAssetsTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Screen.SavedAssets.route,
        startDestination = NavScreen.SavedAssets.createRoute(Screen.SavedAssets)
    ) {
        addSavedAssets(navController, Screen.SavedAssets)
    }
}

//-----------------------------------------------------------------------------------------------------
//Screens

private fun NavGraphBuilder.addCollection(
    navController: NavHostController,
    root: Screen
) {
    composable(route = NavScreen.Collection.createRoute(root)) {
        CollectionList {

        }
    }
}

private fun NavGraphBuilder.addCollectionDetail(
    navController: NavHostController,
    root: Screen
) {
    composable(route = NavScreen.CollectionDetail.createRoute(root)) {
        CollectionDetail()
    }
}

private fun NavGraphBuilder.addAssetDetail(
    navController: NavHostController,
    root: Screen
) {
    composable(route = NavScreen.AssetDetail.createRoute(root)) {
        AssetDetail()
    }
}

private fun NavGraphBuilder.addSavedCollections(
    navController: NavHostController,
    root: Screen,
) {
    composable(route = NavScreen.SavedCollections.createRoute(root)){
        SavedCollections()
    }
}

private fun NavGraphBuilder.addSavedAssets(
    navController: NavHostController,
    root: Screen,
) {
    composable(route = NavScreen.AssetDetail.createRoute(root)) {
        SavedAssets()
    }
}





