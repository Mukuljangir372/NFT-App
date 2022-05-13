package com.mukul.jan.nft.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mukul.jan.common_ui_res.R
import com.mukul.jan.nft.AppNavigation
import com.mukul.jan.nft.Screen

@Composable
internal fun Home() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            HomeBottomBar(
                navController = navController,
                modifier = Modifier,
                onNavItemClick = {
                    navController.navigate(it)
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            AppNavigation(navController = navController)
        }
    }
}

private sealed class HomeBottomBarItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    object Dashboard : HomeBottomBarItem(
        Screen.Collection.route,
        R.drawable.ic_baseline_space_dashboard_24,
        R.string.dashboard
    )

    object Saved : HomeBottomBarItem(
        Screen.Saved.route,
        R.drawable.ic_baseline_bookmarks_24,
        R.string.saved
    )

    object Search : HomeBottomBarItem(
        Screen.Search.route,
        R.drawable.ic_baseline_search_24,
        R.string.search
    )
}


@Composable
private fun HomeBottomBar(
    navController: NavController,
    onNavItemClick: (route: String) -> Unit,
    modifier: Modifier
) {
    val items = listOf(
        HomeBottomBarItem.Dashboard,
        HomeBottomBarItem.Saved,
        HomeBottomBarItem.Search
    )

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentHierarchy = currentBackStack?.destination?.hierarchy

    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 5.dp
    ) {

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentHierarchy?.any {
                  it.route == item.route
                } ?: false,
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(0.5f),
                onClick = {
                    onNavItemClick(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.title),
                    )
                },
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}

