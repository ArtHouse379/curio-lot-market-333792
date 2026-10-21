package fernfieldantiquarianbooks.collectibles.curiolotmarket.data.repository

import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.model.Product
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Leather-Bound Book",
            description = "This late Victorian volume has a deep brown leather binding with gilt tooling and raised bands. The pages show gentle age toning consistent with careful use. Its hinges remain firm, while small scuffs give the cover an appealing library patina. It is a handsome reading copy and display piece.",
            category = ProductCategory.ANTIQUARIAN_BOOKS,
            price = 145.00,
            imageUrl = "https://images.pexels.com/photos/14819818/pexels-photo-14819818.jpeg",
        ),
        Product(
            id = 2,
            title = "Vintage Poetry Book",
            description = "This early twentieth-century poetry volume retains its original cloth binding and deckled pages. A previous owner added a neat inscription to the flyleaf. The text block is complete, with light foxing around the edges. Its compact format makes it an inviting addition to a bedside or study shelf.",
            category = ProductCategory.ANTIQUARIAN_BOOKS,
            price = 68.00,
            imageUrl = "https://images.pexels.com/photos/1333742/pexels-photo-1333742.jpeg",
        ),
        Product(
            id = 3,
            title = "Atlantic Chart",
            description = "This printed nautical chart depicts historic routes across the North Atlantic. The warm paper tone and finely drawn coastlines give it strong period character. Minor creases and softened corners reflect its age without obscuring the detail. It is suitable for archival framing in a study or library.",
            category = ProductCategory.MAPS_AND_PRINTS,
            price = 195.00,
            imageUrl = "https://images.pexels.com/photos/9494912/pexels-photo-9494912.jpeg",
        ),
        Product(
            id = 4,
            title = "Bosphorus Engraving",
            description = "This nineteenth-century style engraving presents the Bosphorus with architectural and maritime details. It is mounted behind glass in a dark wooden frame. The sheet has even toning and a few unobtrusive age marks. Its detailed composition rewards close viewing and suits a traditional interior.",
            category = ProductCategory.MAPS_AND_PRINTS,
            price = 240.00,
            imageUrl = "https://images.pexels.com/photos/8627842/pexels-photo-8627842.jpeg",
        ),
        Product(
            id = 5,
            title = "Pocket Watch",
            description = "This brass pocket watch features an aged dial, traditional numerals, and a winding crown. The case has a mellow patina with fine surface wear from use. Its hands and mechanical movement are presented in working order at the time of cataloguing. The watch is offered as a collectible timepiece rather than a precision instrument.",
            category = ProductCategory.TIMEPIECES,
            price = 325.00,
            imageUrl = "https://images.pexels.com/photos/18506943/pexels-photo-18506943/free-photo-of-vintage-pocket-watch.jpeg",
        ),
        Product(
            id = 6,
            title = "Mantel Clock",
            description = "This wooden mantel clock has a shaped case, carved ornament, and a clear traditional dial. Its warm finish shows small marks expected from decades of display. The movement has been tested over a short period and keeps steady time. A winding key is included with the clock.",
            category = ProductCategory.TIMEPIECES,
            price = 480.00,
            imageUrl = "https://images.pexels.com/photos/14714637/pexels-photo-14714637.jpeg",
        ),
        Product(
            id = 7,
            title = "Porcelain Vase",
            description = "This Japanese porcelain vase is decorated with a restrained blue pattern on a pale ground. The glaze remains bright and the foot ring shows signs of age and handling. No major chips are visible, though light surface wear is present. Its balanced form works equally well as a cabinet piece or table accent.",
            category = ProductCategory.DECORATIVE_ARTS,
            price = 275.00,
            imageUrl = "https://images.pexels.com/photos/20726994/pexels-photo-20726994.jpeg",
        ),
        Product(
            id = 8,
            title = "Brass Candlestick",
            description = "This tall brass candlestick has a turned stem and broad, stable base. A naturally developed patina softens the polished metal and highlights the profile. Traces of old wax remain around the socket, adding authentic domestic character. It can be displayed alone or paired with other period brassware.",
            category = ProductCategory.DECORATIVE_ARTS,
            price = 110.00,
            imageUrl = "https://images.pexels.com/photos/19065452/pexels-photo-19065452.jpeg",
        ),
        Product(
            id = 9,
            title = "Brass Compass",
            description = "This pocket compass has a brass case, printed directional card, and glass cover. The metal has developed an attractive, uneven patina from age. Its needle moves freely, although the instrument is sold for collecting and display. It makes a fitting companion to historic maps and travel ephemera.",
            category = ProductCategory.HISTORICAL_COLLECTIBLES,
            price = 135.00,
            imageUrl = "https://images.pexels.com/photos/14436272/pexels-photo-14436272.jpeg",
        ),
        Product(
            id = 10,
            title = "Coin Collection",
            description = "This small collection brings together circulated copper and silver-toned coins from several periods. Each coin shows readable design elements alongside honest wear. The group is intended as an accessible historical assortment rather than a matched investment set. It arrives in protective sleeves with a simple inventory card.",
            category = ProductCategory.HISTORICAL_COLLECTIBLES,
            price = 160.00,
            imageUrl = "https://images.pexels.com/photos/16701714/pexels-photo-16701714/free-photo-of-collection-of-coins.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
