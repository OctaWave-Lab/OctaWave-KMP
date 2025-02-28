package com.khyzhun.octawavekmp

expect class AudioProcessor {
    fun processAudioFile(filePath: String): String
}