package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.cart.JLKMGCartScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.checkout.JLKMGCheckoutScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.home.JLKMGHomeScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.onboarding.JLKMGOnboardingScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.order.JLKMGOrdersScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.productdetails.JLKMGProductDetailsScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.settings.JLKMGSettingsScreen
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.splash.JLKMGSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            JLKMGSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            JLKMGOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            JLKMGHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            JLKMGProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            JLKMGCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            JLKMGCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            JLKMGOrdersScreen()
        }

        composable<NavRoute.Settings> {
            JLKMGSettingsScreen()
        }
    }
}