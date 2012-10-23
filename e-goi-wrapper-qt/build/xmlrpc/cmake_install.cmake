# Install script for directory: /Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc

# Set the install prefix
IF(NOT DEFINED CMAKE_INSTALL_PREFIX)
  SET(CMAKE_INSTALL_PREFIX "/usr/local")
ENDIF(NOT DEFINED CMAKE_INSTALL_PREFIX)
STRING(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
IF(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  IF(BUILD_TYPE)
    STRING(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  ELSE(BUILD_TYPE)
    SET(CMAKE_INSTALL_CONFIG_NAME "")
  ENDIF(BUILD_TYPE)
  MESSAGE(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
ENDIF(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)

# Set the component getting installed.
IF(NOT CMAKE_INSTALL_COMPONENT)
  IF(COMPONENT)
    MESSAGE(STATUS "Install component: \"${COMPONENT}\"")
    SET(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  ELSE(COMPONENT)
    SET(CMAKE_INSTALL_COMPONENT)
  ENDIF(COMPONENT)
ENDIF(NOT CMAKE_INSTALL_COMPONENT)

IF(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")
  FILE(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/xmlrpc" TYPE FILE FILES
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/client.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/qxmlrpc_documentation.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/request.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/response.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/server.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/server_private.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/serverintrospection.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/stable.h"
    "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/xmlrpc/variant.h"
    )
ENDIF(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")

IF(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")
  FILE(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib" TYPE SHARED_LIBRARY FILES "/Volumes/Data/Users/luislobo/git/e-goi-wrappers/e-goi-wrapper-cpp/build/lib/libxmlrpc.dylib")
  IF(EXISTS "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/libxmlrpc.dylib" AND
     NOT IS_SYMLINK "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/libxmlrpc.dylib")
    EXECUTE_PROCESS(COMMAND "/usr/bin/install_name_tool"
      -id "libxmlrpc.dylib"
      "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/libxmlrpc.dylib")
    IF(CMAKE_INSTALL_DO_STRIP)
      EXECUTE_PROCESS(COMMAND "/usr/bin/strip" "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/libxmlrpc.dylib")
    ENDIF(CMAKE_INSTALL_DO_STRIP)
  ENDIF()
ENDIF(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")

