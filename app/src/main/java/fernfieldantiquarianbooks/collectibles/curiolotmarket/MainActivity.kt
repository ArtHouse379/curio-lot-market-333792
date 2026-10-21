package fernfieldantiquarianbooks.collectibles.curiolotmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.composable.approot.AppRoot
import fernfieldantiquarianbooks.collectibles.curiolotmarket.ui.theme.JLKMGAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JLKMGAppTheme {
                AppRoot()
            }
        }
    }
}
