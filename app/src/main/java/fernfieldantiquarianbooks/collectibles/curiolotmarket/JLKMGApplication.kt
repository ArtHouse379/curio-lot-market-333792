package fernfieldantiquarianbooks.collectibles.curiolotmarket

import android.app.Application
import fernfieldantiquarianbooks.collectibles.curiolotmarket.di.dataModule
import fernfieldantiquarianbooks.collectibles.curiolotmarket.di.dispatcherModule
import fernfieldantiquarianbooks.collectibles.curiolotmarket.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class JLKMGApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@JLKMGApplication)
            modules(appModules)
        }
    }
}
