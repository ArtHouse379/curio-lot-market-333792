package fernfieldantiquarianbooks.collectibles.curiolotmarket.di

import androidx.room.Room
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.database.JLKMGAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "jlkmg_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = JLKMGAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<JLKMGAppDatabase>().cartItemDao() }

    single { get<JLKMGAppDatabase>().orderDao() }
}