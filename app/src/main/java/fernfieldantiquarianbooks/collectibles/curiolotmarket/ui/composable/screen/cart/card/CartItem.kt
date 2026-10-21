package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.cart.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fernfieldantiquarianbooks.collectibles.curiolotmarket.R
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.shared.ProductImage
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.state.CartItemUiState
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.LocalDimens
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.cardBorderStroke
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.controlBorderStroke
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.imageBorder

private val ImageSize = 56.dp
private val StepperButtonSize = 32.dp
private val StepperIconSize = 16.dp

private const val LAST_ITEM_QUANTITY = 1

@Composable
fun CartItem(
    item: CartItemUiState,
    modifier: Modifier = Modifier,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    val dimens = LocalDimens.current
    val imageShape = RoundedCornerShape(dimens.cornerRadius)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Row(
            modifier = Modifier.padding(dimens.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProductImage(
                imageUrl = item.productImageUrl,
                modifier = Modifier
                    .size(ImageSize)
                    .clip(imageShape)
                    .imageBorder(imageShape),
            )

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.productTitle,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Text(
                    text = stringResource(R.string.price, item.productPrice * item.quantity),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            val isLastItem = item.quantity <= LAST_ITEM_QUANTITY

            Surface(
                shape = RoundedCornerShape(dimens.controlCornerRadius),
                color = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                border = controlBorderStroke(),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = if (isLastItem) onDeleteClick else onMinusClick,
                        modifier = Modifier.size(StepperButtonSize),
                    ) {
                        Icon(
                            imageVector = if (isLastItem) {
                                Icons.Default.Delete
                            } else {
                                Icons.Default.Remove
                            },
                            contentDescription = stringResource(
                                if (isLastItem) {
                                    R.string.delete_item_icon_description
                                } else {
                                    R.string.decrease_quantity_icon_description
                                }
                            ),
                            tint = if (isLastItem) {
                                MaterialTheme.colorScheme.error
                            } else {
                                MaterialTheme.colorScheme.onSecondaryContainer
                            },
                            modifier = Modifier.size(StepperIconSize),
                        )
                    }

                    Text(
                        text = item.quantity.toString(),
                        style = MaterialTheme.typography.labelLarge,
                    )

                    IconButton(
                        onClick = onPlusClick,
                        modifier = Modifier.size(StepperButtonSize),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(
                                R.string.increase_quantity_icon_description
                            ),
                            modifier = Modifier.size(StepperIconSize),
                        )
                    }
                }
            }
        }
    }
}
