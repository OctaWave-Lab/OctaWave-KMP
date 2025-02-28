package com.khyzhun.octawavekmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: AudioViewModel) {
    MaterialTheme {
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
                onClick = { processedAudio = viewModel.startProcessing() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Process Audio")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Processed Audio: $processedAudio")
        }
    }
}