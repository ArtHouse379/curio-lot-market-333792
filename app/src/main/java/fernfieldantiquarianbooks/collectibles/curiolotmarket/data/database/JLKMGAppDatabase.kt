package fernfieldantiquarianbooks.collectibles.curiolotmarket.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.database.dao.CartItemDao
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.database.dao.OrderDao
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.database.converter.Converters
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.entity.CartItemEntity
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class JLKMGAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}