package ir.net_box.test.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.net_box.test.ui.detail.DetailScreen
import ir.net_box.test.ui.main.MainScreen

@Composable
fun NetBoxNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "main") {

        composable(route = "main") {
            MainScreen(
                onVideoClick = { video ->
                    navController.navigate("detail/${video.id}")
                }
            )
        }

        composable(
            route = "detail/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getInt("videoId") ?: return@composable
            DetailScreen(
                videoId = videoId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
