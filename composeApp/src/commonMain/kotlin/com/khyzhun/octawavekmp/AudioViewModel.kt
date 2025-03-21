package com.khyzhun.octawavekmp

import androidx.lifecycle.ViewModel

class AudioViewModel(
    private val processor: AudioProcessor,
    private val recorder: AudioRecorder
) : ViewModel() {
    fun startRecording() {
        recorder.startRecording()
    }

    fun processAudio(): String {
        val filePath = recorder.getRecordedFilePath()
        val result = processor.processAudioFile(filePath)
        println("AudioViewModel | result=$result")
        return result
    }
}
