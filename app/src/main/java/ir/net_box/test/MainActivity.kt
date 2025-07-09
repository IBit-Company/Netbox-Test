package ir.net_box.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.tv.material3.ExperimentalTvMaterial3Api
import dagger.hilt.android.AndroidEntryPoint
import ir.net_box.test.ui.main.MainScreen
import ir.net_box.test.ui.theme.NetboxTestApplicationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetboxTestApplicationTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    MainScreen(
                        onVideoClick = {
                            // TODO Navigate to detail screen
                        }
                    )
                }
            }
        }
    }
}
