package com.khyzhun.octawavekmp

expect class AudioRecorder {
    fun startRecording()
    fun stopRecording()
    fun getRecordedFilePath(): String
}