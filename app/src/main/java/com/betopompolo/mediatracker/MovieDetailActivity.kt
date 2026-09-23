package com.betopompolo.mediatracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betopompolo.mediatracker.ui.theme.MediaTrackerTheme

class MovieDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediaTrackerTheme {
                MovieDetailPage()
            }
        }
    }
}

@Composable
fun MovieDetailPage() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            MediaTrackerCard(title = "Blade Runner 2049", content = {
                Text("Thirty years after the events of the\n" +
                        "first film, a new blade runner, LAPD\n" +
                        "Officer K, unearths a long-buried\n" +
                        "secret that has the potential to\n" +
                        "plunge what's left of society into\n" +
                        "chaos. K's discovery leads him on a\n" +
                        "quest to find Rick Deckard, a former\n" +
                        "LAPD blade runner who has been\n" +
                        "missing for 30 years. The journey\n" +
                        "takes him deep into the irradiated\n" +
                        "wastelands outside Los Angeles and\n" +
                        "into the heart of the Wallace\n" +
                        "Corporation's secretive operations.")

            })

            MediaTrackerCard(title = "Details") {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Director")
                    Text("Denis Villeneuve")
                }
            }
        }
    }
}

@Composable
fun MediaTrackerCard(title: String, content: @Composable () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.headlineLarge)
            content()
        }
    }
}

@Preview
@Composable
fun MovieDetailPagePreview() {
    MediaTrackerTheme {
        MovieDetailPage()
    }
}
