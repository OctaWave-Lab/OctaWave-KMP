package com.khyzhun.octawavekmp

actual class AudioProcessor {

    init {
        // Ensure the native library is loaded
        System.loadLibrary("native-lib")
    }

    // Declare C++ function
    actual external fun processAudioFile(filePath: String): String

}