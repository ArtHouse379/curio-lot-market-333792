package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.settings.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fernfieldantiquarianbooks.collectibles.curiolotmarket.R
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.LocalDimens
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.cardBorderStroke
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.controlBorderStroke
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.imageBorder

private val LogoSize = 56.dp

@Composable
fun AppInfoCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val logoShape = RoundedCornerShape(dimens.cornerRadius)
    val companyName = stringResource(R.string.jlkmg_company_name)

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
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.app_name),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                if (companyName.isNotBlank()) {
                    Text(
                        text = companyName,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                VersionBadge()
            }

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = stringResource(R.string.jlkmg_app_logo_description),
                modifier = Modifier
                    .size(LogoSize)
                    .clip(logoShape)
                    .imageBorder(logoShape),
            )
        }
    }
}

@Composable
private fun VersionBadge(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(dimens.controlCornerRadius),
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        border = controlBorderStroke(),
    ) {
        Text(
            text = "${stringResource(R.string.settings_screen_version_label)} " +
                    stringResource(R.string.jlkmg_app_version),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}
