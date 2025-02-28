package com.khyzhun.octawavekmp

class AudioViewModel(
    private val audioRecorder: AudioRecorder
) {

    fun startRecording() {
        audioRecorder.onStartRecording()
    }

    fun stopRecording() {
        audioRecorder.onStopRecording()
    }

}