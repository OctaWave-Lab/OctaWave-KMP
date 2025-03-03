#include "AudioProcessor.h"
#include "CoreAudioProcessor.h"

std::string processAudioFileInAndroid(const std::string& filePath) {
    return ::processAudioFileInProcessor(filePath);
}