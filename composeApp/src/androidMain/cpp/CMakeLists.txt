cmake_minimum_required(VERSION 3.10)
project(OctaWaveNative)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")

# Define the path to OctaWave-Processor
set(OCTAWAVE_PROCESSOR_PATH "${CMAKE_SOURCE_DIR}/../../../../external/OctaWave-Processor")

# Ensure it's added as a STATIC library
if (EXISTS ${OCTAWAVE_PROCESSOR_PATH})
    add_subdirectory(${OCTAWAVE_PROCESSOR_PATH} ${CMAKE_BINARY_DIR}/OctaWave-Processor)
else()
    message(FATAL_ERROR "OctaWave-Processor not found! Expected at ${OCTAWAVE_PROCESSOR_PATH}")
endif()

# Include the headers
include_directories(${OCTAWAVE_PROCESSOR_PATH}/src)

# Create native library for Android
add_library(native-lib SHARED native-lib.cpp AudioProcessor.cpp)

# Link the OctaWaveProcessor static library and Android logging
target_link_libraries(native-lib
        OctaWaveProcessor  # Link the external C++ processor
        log  # Android logging
)