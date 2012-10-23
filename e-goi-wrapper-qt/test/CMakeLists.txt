SET( executable_name "egoi-test" )

SET(sources
    main.cpp
)

INCLUDE_DIRECTORIES(
    ${PROJECT_SOURCE_DIR}/test
    ${PROJECT_SOURCE_DIR}/xmlrpc
    ${PROJECT_SOURCE_DIR}/src
)

ADD_EXECUTABLE(${executable_name} WIN32 ${sources} ${moc_sources} )

INCLUDE(${QT_USE_FILE})

ADD_DEFINITIONS(${QT_DEFINITIONS})

SET( QT_USE_QT3SUPPORT TRUE )
SET(QT_USE_QTXML TRUE)
SET(QT_USE_QTNETWORK TRUE)

TARGET_LINK_LIBRARIES(${executable_name} ${QT_LIBRARIES} egoi xmlrpc)

LINK_DIRECTORIES(${PROJECT_BINARY_DIR}/lib)
