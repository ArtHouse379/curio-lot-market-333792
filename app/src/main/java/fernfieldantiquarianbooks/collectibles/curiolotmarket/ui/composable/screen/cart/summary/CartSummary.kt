package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.cart.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import fernfieldantiquarianbooks.collectibles.curiolotmarket.R
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.approot.LocalContentBottomPadding
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.ControlDivider
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.LocalDimens

@Composable
fun CartSummary(
    itemsCount: Int,
    totalPrice: Double,
    modifier: Modifier = Modifier,
    onCompleteOrderButtonClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainer),
    ) {
        ControlDivider()

        Column(
            modifier = Modifier.padding(
                start = dimens.screenPadding,
                top = dimens.screenPadding,
                end = dimens.screenPadding,
                bottom = dimens.screenPadding + LocalContentBottomPadding.current,
            ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(R.string.cart_items_count, itemsCount),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Text(
                    text = stringResource(R.string.price_total, totalPrice),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            Button(
                onClick = onCompleteOrderButtonClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Text(text = stringResource(R.string.button_place_order_label, totalPrice))
            }
        }
    }
}
