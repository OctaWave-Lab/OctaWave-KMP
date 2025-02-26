#include <jni.h>
#include <android/log.h>
#include <string>

#define LOG_TAG "OctaWaveNative"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT jstring JNICALL
Java_com_khyzhun_octawavekmp_AudioProcessor_process(JNIEnv* env, jobject obj) {
    LOGI("Hello from C++! 2");

    // Proper return value
    return env->NewStringUTF("Hello from C++! Process executed.");
}
