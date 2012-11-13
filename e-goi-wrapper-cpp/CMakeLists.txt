CMAKE_MINIMUM_REQUIRED(VERSION 2.8)

PROJECT(egoilib)

# Required Libs
# FIND_PACKAGE(Qt4 4.8.3 COMPONENTS QtCore QtGui QtNetwork QtXml REQUIRED)
FIND_PACKAGE(XMLRPC REQUIRED
	# c++            # legacy C++ wrapper API
	c++2           # modern C++ API
	client         # client functions
	# cgi-server     # CGI-based server functions
	# abyss-server   # ABYSS-based server functions
	# pstream-server # pstream-based server functions
	# server-util    # basic server functions (implied by *-server)
)

# FOREACH(lib ${XMLRPC_LIBRARIES})
#	MESSAGE("[lib] " ${lib})
# endforeach(lib)

SET(CMAKE_MODULE_PATH ${egoilib_SOURCE_DIR}/cmake)

OPTION(DEVEL_MODE "Enable Development Mode")

# Egoi Lib
MESSAGE(STATUS "Egoi Library type: shared")

SUBDIRS(src test)

INCLUDE_DIRECTORIES(${egoilib_SOURCE_DIR} ${egoilib_BINARY_DIR} ${XMLRPC_INCLUDE_DIRS})

CONFIGURE_FILE(${egoilib_SOURCE_DIR}/config.h.in ${egoilib_BINARY_DIR}/config.h)

SET(LIBRARY_OUTPUT_PATH ${egoilib_BINARY_DIR}/lib)

SET(EXECUTABLE_OUTPUT_PATH ${egoilib_BINARY_DIR})
