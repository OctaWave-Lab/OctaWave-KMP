package com.khyzhun.octawavekmp

import androidx.lifecycle.ViewModel

class AudioViewModel(
    private val processor: AudioProcessor,
    private val recorder: AudioRecorder
) : ViewModel() {

    fun startRecording() {
        recorder.startRecording()
    }

    fun stopRecording() {
        recorder.stopRecording()
    }

    fun processAudio(): String {
        val filePath = recorder.getRecordedFilePath()
        return processor.processAudioFile(filePath)
    }
}
