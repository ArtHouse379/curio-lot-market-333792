package fernfieldantiquarianbooks.collectibles.curiolotmarket.data.model

import androidx.annotation.StringRes
import fernfieldantiquarianbooks.collectibles.curiolotmarket.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    ANTIQUARIAN_BOOKS(R.string.product_category_antiquarian_books_title),
    MAPS_AND_PRINTS(R.string.product_category_maps_and_prints_title),
    TIMEPIECES(R.string.product_category_timepieces_title),
    DECORATIVE_ARTS(R.string.product_category_decorative_arts_title),
    HISTORICAL_COLLECTIBLES(R.string.product_category_historical_collectibles_title),
}
