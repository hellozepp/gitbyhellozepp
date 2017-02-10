cmake_minimum_required(VERSION 3.6)
project(project)
SET(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -O0 -Wall -g -ggdb -std=c++11")
SET(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS} -O3 -Wall -std=c++11")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

ADD_SUBDIRECTORY( org.zl )

set(SOURCE_FILES main.cpp)
AUX_SOURCE_DIRECTORY(. DIR_SRCS)
add_executable(project ${DIR_SRCS})
TARGET_LINK_LIBRARIES( project ZL)