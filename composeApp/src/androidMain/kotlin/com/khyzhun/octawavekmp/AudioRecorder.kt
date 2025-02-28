package com.khyzhun.octawavekmp

import android.media.MediaRecorder
import android.util.Log
import java.io.File

actual class AudioRecorder {

    private var mediaRecorder: MediaRecorder? = null
    private var outputFile: String? = null

    actual fun onStartRecording() {
        try {
            outputFile = File.createTempFile("recording", ".3gp").absolutePath
            mediaRecorder = MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setOutputFile(outputFile)
                prepare()
                start()
            }
            Log.d("AudioRecorder", "Recording started: $outputFile")
        } catch (e: Exception) {
            Log.e("AudioRecorder", "Error starting recording", e)
        }
    }

    actual fun onStopRecording() {
        try {
            mediaRecorder?.apply {
                stop()
                release()
            }
            mediaRecorder = null
            Log.d("AudioRecorder", "Recording stopped. File saved at: $outputFile")
        } catch (e: Exception) {
            Log.e("AudioRecorder", "Error stopping recording", e)
        }
    }
}