cmake_minimum_required(VERSION 3.10)
project(OctaWaveNative)

set(CMAKE_CXX_STANDARD 17)

# Define the path to OctaWave-Processor
set(OCTAWAVE_PROCESSOR_PATH "${CMAKE_SOURCE_DIR}/../../../../external/OctaWave-Processor")

# Check if the path exists
if (EXISTS ${OCTAWAVE_PROCESSOR_PATH})
    add_subdirectory(${OCTAWAVE_PROCESSOR_PATH} ${CMAKE_BINARY_DIR}/OctaWave-Processor)
else()
    message(FATAL_ERROR "OctaWave-Processor not found! Expected at ${OCTAWAVE_PROCESSOR_PATH}")
endif()

# Include the header files
include_directories(${OCTAWAVE_PROCESSOR_PATH}/include)

# Create the native library
add_library(native-lib SHARED native-lib.cpp AudioProcessor.cpp)

# Link OctaWave-Processor and log library
target_link_libraries(native-lib audio_processor log)