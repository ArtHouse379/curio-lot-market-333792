package fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.screen.onboarding.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.LocalDimens
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.imageBorder

private val BackdropSize = 152.dp
private val IconSize = 32.dp

@Composable
fun OnboardingIcon(
    icons: List<ImageVector>,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Box(
        modifier = modifier
            .size(BackdropSize)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .imageBorder(CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing)) {
            icons.forEach { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(IconSize),
                )
            }
        }
    }
}
