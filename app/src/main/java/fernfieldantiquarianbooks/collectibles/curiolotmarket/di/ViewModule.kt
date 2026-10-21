package fernfieldantiquarianbooks.collectibles.curiolotmarket.di

import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.AppViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.CartViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.CheckoutViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.OnboardingViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.OrderViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.ProductDetailsViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.ProductViewModel
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}