package com.khyzhun.octawavekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform