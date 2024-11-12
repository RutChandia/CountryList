package cl.rutchandia.thesportsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cl.rutchandia.thesportsapp.navigation.CountryNav
import cl.rutchandia.thesportsapp.ui.theme.TheSportsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheSportsAppTheme {
                Surface(modifier = Modifier.background(colorScheme.background)) {
                    CountryNav()
                }
            }
        }
    }
}
