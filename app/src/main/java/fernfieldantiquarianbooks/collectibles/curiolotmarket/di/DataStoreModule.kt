package fernfieldantiquarianbooks.collectibles.curiolotmarket.di

import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}