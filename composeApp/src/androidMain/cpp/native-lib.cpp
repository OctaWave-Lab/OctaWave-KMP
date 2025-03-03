#include <jni.h>
#include <string>
#include "AudioProcessor.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_khyzhun_octawavekmp_AudioProcessor_processAudioFile(JNIEnv* env, jobject obj, jstring filePath) {
    const char* nativeFilePath = env->GetStringUTFChars(filePath, nullptr);
    std::string result = processAudioFileInAndroid(nativeFilePath);
    env->ReleaseStringUTFChars(filePath, nativeFilePath);
    return env->NewStringUTF(result.c_str());
}