package com.khyzhun.octawavekmp

actual object AudioProcessor {

    init {
        // Ensure the native library is loaded
        System.loadLibrary("native-lib")
    }

    // Declare C++ function
    actual external fun process(): String
}