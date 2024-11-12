package cl.rutchandia.thesportsapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cl.rutchandia.thesportsapp.R

@Composable
fun TryAgainButton(onTryAgain: () -> Unit, message: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StateMessage(message = message)
        Button(onClick = onTryAgain) {
            Text(text = stringResource(R.string.try_again))
        }
    }
}