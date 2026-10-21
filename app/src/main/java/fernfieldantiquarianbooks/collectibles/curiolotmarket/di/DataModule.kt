package fernfieldantiquarianbooks.collectibles.curiolotmarket.di

import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.repository.CartRepository
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.repository.OnboardingRepository
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.repository.OrderRepository
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}