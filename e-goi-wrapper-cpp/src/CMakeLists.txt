SET(sources
	egoi.cpp
	egoimap.cpp
	egoixmlrpc.cpp
)

ADD_LIBRARY(egoi SHARED ${sources})

TARGET_LINK_LIBRARIES(egoi ${XMLRPC_LIBRARIES})

INSTALL_TARGETS(/lib egoi)
INSTALL_FILES(/include/egoi .*\\.h$)

LINK_DIRECTORIES(${CMAKE_BINARY_DIR}/lib)
