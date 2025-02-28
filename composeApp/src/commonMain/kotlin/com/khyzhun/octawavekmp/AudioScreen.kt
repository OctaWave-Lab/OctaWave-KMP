package com.khyzhun.octawavekmp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

@Composable
fun AudioScreen(viewModel: AudioViewModel) {
    var isRecording by remember { mutableStateOf(false) }
    var processedAudio by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (isRecording) {
                    viewModel.stopRecording()
                } else {
                    viewModel.startRecording()
                }
                isRecording = !isRecording
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isRecording) "Stop Recording" else "Start Recording")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { processedAudio = viewModel.processAudio() },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isRecording
        ) {
            Text("Process Audio")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Processed Audio: $processedAudio")
    }
}
