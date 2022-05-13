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
import com.mukul.jan.ui_saved.SavedScreen
import com.mukul.jan.ui_search.SearchScreen

internal sealed class Screen(val route: String) {
    object Collection : Screen("collection")
    object Saved : Screen("Saved")
    object Search : Screen("Search")
}

internal sealed class NavScreen(
    private val route: String
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object Collection : NavScreen("collection")
    object Saved : NavScreen("Saved")
    object Search : NavScreen("Search")

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
        addSavedTopLevel(navController)
        addSearchTopLevel(navController)
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

private fun NavGraphBuilder.addSavedTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Screen.Saved.route,
        startDestination = NavScreen.Saved.createRoute(Screen.Saved)
    ) {
        addSaved(navController, Screen.Saved)
    }
}

private fun NavGraphBuilder.addSearchTopLevel(
    navController: NavHostController
){
    navigation(
        route = Screen.Search.route,
        startDestination = NavScreen.Search.createRoute(Screen.Search)
    ){
        addSearch(navController,Screen.Search)
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

private fun NavGraphBuilder.addSaved(
    navController: NavHostController,
    root: Screen,
) {
    composable(route = NavScreen.Saved.createRoute(root)){
        SavedScreen()
    }
}

private fun NavGraphBuilder.addSearch(
    navController: NavHostController,
    root: Screen,
) {
    composable(route = NavScreen.Search.createRoute(root)) {
        SearchScreen()
    }
}





