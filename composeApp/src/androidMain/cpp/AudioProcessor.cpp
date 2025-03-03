#include "CoreAudioProcessor.h"

std::string processAudioFileInAndroid(const std::string& filePath) {
    return OctaWave::processAudioFileInProcessor(filePath);
}