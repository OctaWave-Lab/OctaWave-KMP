package com.khyzhun.octawavekmp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 1488)
        }

        val audioProcessor = AudioProcessor()
        val audioRecorder = AudioRecorder()
        val viewModel = AudioViewModel(audioProcessor, audioRecorder)

        setContent {
            AudioScreen(viewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
}