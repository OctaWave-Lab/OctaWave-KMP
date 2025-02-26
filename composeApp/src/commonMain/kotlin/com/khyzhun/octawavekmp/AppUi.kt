package org.khyzhun.octawavekmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(startAudioRecording: (() -> Unit)? = null) {
    MaterialTheme {
        var isRecording by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (isRecording) "Recording..." else "Tap to Start Recording",
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
//                    if (isRecording) {
//                        onStopRecording()
//                    } else {
//                        onStartRecording()
//                    }
                    startAudioRecording?.let { it() }
                    isRecording = !isRecording
                }
            ) {
                Text(text = if (isRecording) "Stop" else "Start")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {}) {
                Text(text = "Back")
            }
        }
    }
}