cmake_minimum_required(VERSION 3.10)
project(OctaWaveNative)

set(CMAKE_CXX_STANDARD 17)

# Add Android NDK includes
include_directories(${ANDROID_NDK}/sources/android/support/include)

# Add OctaWave Processor Library
set(OCTAWAVE_PROCESSOR_PATH "${CMAKE_SOURCE_DIR}/../../../../external/OctaWave-Processor")

if (EXISTS ${OCTAWAVE_PROCESSOR_PATH})
    add_subdirectory(${OCTAWAVE_PROCESSOR_PATH} ${CMAKE_BINARY_DIR}/OctaWave-Processor)
else()
    message(FATAL_ERROR "OctaWave-Processor not found! Expected at ${OCTAWAVE_PROCESSOR_PATH}")
endif()

# Create Native Library
add_library(
        native-lib SHARED
        native-lib.cpp
        AudioProcessor.cpp
)

# Link with OctaWave Processor and log library
target_link_libraries(native-lib audio_processor log)
