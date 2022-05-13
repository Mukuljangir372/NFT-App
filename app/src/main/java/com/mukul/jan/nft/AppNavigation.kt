package com.mukul.jan.nft

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

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
        fun createRoute(root: Screen, id: String): String {
            return "${root.route}/collectionDetail/{$id}"
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
    }
}

private fun NavGraphBuilder.addSavedCollectionsTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Screen.SavedCollections.route,
        startDestination = NavScreen.SavedCollections.createRoute(Screen.SavedCollections)
    ) {

    }
}

private fun NavGraphBuilder.addSavedAssetsTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Screen.SavedAssets.route,
        startDestination = NavScreen.SavedAssets.createRoute(Screen.SavedAssets)
    ) {

    }
}

//-----------------------------------------------------------------------------------------------------
//Screens

private fun NavGraphBuilder.addCollection(
    navController: NavHostController,
    root: Screen
) {
    composable(route = NavScreen.Collection.createRoute(root)) {

    }
}

private fun NavGraphBuilder.addCollectionDetail(
    navController: NavHostController,
    root: Screen
){
    composable(route = NavScreen.CollectionDetail.createRoute(root)){

    }
}




