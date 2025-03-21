package com.khyzhun.octawavekmp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AudioScreen(viewModel: AudioViewModel) {
    var processedAudio by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.startRecording()
        while (true) {
            delay(1000)
            processedAudio = viewModel.processAudio()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Detected Frequency: $processedAudio")
    }
}
