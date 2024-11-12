package cl.rutchandia.thesportsapp.presentation.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun StateMessage(message: Int) {
    Text(
        text = stringResource(id = message),
        style = MaterialTheme.typography.bodyLarge
    )
}