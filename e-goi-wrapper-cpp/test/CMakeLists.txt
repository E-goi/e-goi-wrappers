SET( executable_name "egoi-test" )

SET( sources
	main.cpp
)

INCLUDE_DIRECTORIES(${PROJECT_SOURCE_DIR}/test ${PROJECT_SOURCE_DIR}/src)
# ADD_DEFINITIONS(-DQT3_SUPPORT ${QT_DEFINITIONS})
# ADD_DEFINITIONS(${QT_DEFINITIONS})

# QT_ADD_RESOURCES(sources resources.qrc)

ADD_EXECUTABLE( ${executable_name} WIN32 ${sources} ${moc_sources} )
TARGET_LINK_LIBRARIES( ${executable_name}
	egoi
)


LINK_DIRECTORIES(${PROJECT_BINARY_DIR}/lib)
