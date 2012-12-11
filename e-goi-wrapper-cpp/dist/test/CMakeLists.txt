SET(executable_name "egoi-test")

SET(sources
	main.cpp
)

INCLUDE_DIRECTORIES(
	${PROJECT_SOURCE_DIR}/test
	${PROJECT_SOURCE_DIR}/src
)

ADD_EXECUTABLE(${executable_name} WIN32 ${sources})

TARGET_LINK_LIBRARIES(${executable_name} ${XMLRPC_LIBRARIES} egoi)

LINK_DIRECTORIES(${PROJECT_BINARY_DIR}/lib)
