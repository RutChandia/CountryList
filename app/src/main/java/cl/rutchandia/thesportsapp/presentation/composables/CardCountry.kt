package cl.rutchandia.thesportsapp.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun CardCountry(countryName: String, countryFlag: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceBright,
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = countryFlag,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(50.dp)
                    .padding(start = 16.dp)
            )
            Text(
                text = countryName,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = colorScheme.onSurface
            )
        }
    }
}
