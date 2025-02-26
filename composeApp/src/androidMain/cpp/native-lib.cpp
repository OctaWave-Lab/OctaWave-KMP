#include <jni.h>
#include <android/log.h>

#define LOG_TAG "OctaWaveNative"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT void JNICALL
Java_com_khyzhun_octawavekmp_AudioProcessor_nativePrint(JNIEnv* env, jobject obj) {
    LOGI("Hello from C++! 2");
}
