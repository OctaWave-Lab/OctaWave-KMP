package org.khyzhun.octawavekmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(startAudioRecording = {
                AudioProcessor.process()
            })
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(startAudioRecording = {
        AudioProcessor.process()
    })
}