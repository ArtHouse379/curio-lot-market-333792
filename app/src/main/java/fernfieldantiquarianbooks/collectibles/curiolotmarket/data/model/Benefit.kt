package fernfieldantiquarianbooks.collectibles.curiolotmarket.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Verified
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Filled.Verified,
        text = "Expert authenticity checks",
    ),
    Benefit(
        icon = Icons.Filled.Shield,
        text = "14-day condition guarantee",
    ),
    Benefit(
        icon = Icons.Filled.HistoryEdu,
        text = "History worth preserving",
    ),
)
