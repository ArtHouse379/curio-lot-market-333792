package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.order.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import fernfieldantiquarianbooks.collectibles.curiolotmarket.data.entity.OrderEntity
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.LocalDimens
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.cardBorderStroke
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.controlBorderStroke
import java.time.format.DateTimeFormatter
import java.util.Locale

private val StatusDotSize = 6.dp
private val CardDividerWidth = 1.dp

@Composable
fun OrderItem(
    order: OrderEntity,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val dateFormatter = DateTimeFormatter.ofPattern(
        stringResource(R.string.order_date_pattern),
        Locale.ENGLISH,
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Column(modifier = Modifier.padding(dimens.cardPadding)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(R.string.order_number, order.orderNumber),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleSmall,
                    )

                    Text(
                        text = order.timestamp.format(dateFormatter),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                StatusBadge()
            }

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            Text(
                text = order.description,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(dimens.tightSpacing))

            Text(
                text = stringResource(
                    R.string.order_customer,
                    order.customerFirstName,
                    order.customerLastName,
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = stringResource(R.string.order_customer_email, order.customerEmail),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        HorizontalDivider(
            thickness = CardDividerWidth,
            color = MaterialTheme.colorScheme.outlineVariant,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                .padding(dimens.cardPadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.order_total_label),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
            )

            Text(
                text = stringResource(R.string.price, order.price),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Composable
private fun StatusBadge(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(dimens.controlCornerRadius),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        border = controlBorderStroke(),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(StatusDotSize)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary),
            )

            Spacer(modifier = Modifier.width(dimens.tightSpacing))

            Text(
                text = stringResource(R.string.order_status_confirmed),
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}
