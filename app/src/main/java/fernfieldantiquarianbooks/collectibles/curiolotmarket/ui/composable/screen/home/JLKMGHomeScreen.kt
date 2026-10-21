package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import fernfieldantiquarianbooks.collectibles.curiolotmarket.R
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.model.Product
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.model.ProductCategory
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.approot.LocalContentBottomPadding
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.home.card.ProductItem
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.home.filter.CategoryFilterRow
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.home.slider.FeaturedSlider
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.shared.DataBasedContainer
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.shared.DataEmptyContent
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.shared.sectiontitle.SectionTitle
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.state.DataUiState
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.ControlDivider
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.LocalDimens
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel

private const val FEATURED_PRODUCTS_COUNT = 3

@Composable
fun JLKMGHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = koinViewModel(),
    onNavigateToProductDetails: (productId: Int) -> Unit,
) {
    val productsState by viewModel.productsState.collectAsState()

    HomeContent(
        productsState = productsState,
        modifier = modifier,
        onNavigateToProductDetails = onNavigateToProductDetails,
        onAddProductToCart = viewModel::addToCart,
    )
}

@Composable
private fun HomeContent(
    productsState: DataUiState<List<Product>>,
    modifier: Modifier = Modifier,
    onNavigateToProductDetails: (productId: Int) -> Unit,
    onAddProductToCart: (productId: Int) -> Unit,
) {
    Column(modifier = modifier) {

        DataBasedContainer(
            modifier = Modifier.fillMaxSize(),
            dataState = productsState,

            dataPopulated = {
                val data = (productsState as DataUiState.Populated<List<Product>>).data

                ProductsList(
                    products = data,
                    onProductClick = onNavigateToProductDetails,
                    onAddToCartClick = onAddProductToCart,
                )
            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.products_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}

@Composable
private fun ProductsList(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (productId: Int) -> Unit,
    onAddToCartClick: (productId: Int) -> Unit,
) {
    var selectedCategory by rememberSaveable { mutableStateOf<ProductCategory?>(null) }

    val visibleProducts = remember(products, selectedCategory) {
        val category = selectedCategory
        if (category == null) products else products.filter { it.category == category }
    }

    val dimens = LocalDimens.current

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = dimens.screenPadding,
            bottom = dimens.screenPadding + LocalContentBottomPadding.current,
        ),
        verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
    ) {
        item {
            SectionTitle(
                text = stringResource(R.string.home_featured_title),
                modifier = Modifier.padding(horizontal = dimens.screenPadding),
            )
        }

        item {
            FeaturedSlider(
                products = products.take(FEATURED_PRODUCTS_COUNT),
                onProductClick = onProductClick,
            )
        }

        item {
            SectionTitle(
                text = stringResource(R.string.home_categories_title),
                modifier = Modifier.padding(horizontal = dimens.screenPadding),
            )
        }

        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainer),
            ) {
                CategoryFilterRow(
                    modifier = Modifier.padding(
                        top = dimens.tightSpacing,
                        bottom = dimens.contentSpacing,
                    ),
                    selectedCategory = selectedCategory,
                    onCategoryClick = { category -> selectedCategory = category },
                )

                ControlDivider()
            }
        }

        item {
            SectionTitle(
                text = stringResource(R.string.home_products_title),
                modifier = Modifier.padding(horizontal = dimens.screenPadding),
                count = visibleProducts.size,
            )
        }

        items(items = visibleProducts, key = { product -> product.id }) { product ->
            ProductItem(
                product = product,
                modifier = Modifier.padding(horizontal = dimens.screenPadding),
                onClick = { onProductClick(product.id) },
                onAddToCartClick = { onAddToCartClick(product.id) },
            )
        }
    }
}
