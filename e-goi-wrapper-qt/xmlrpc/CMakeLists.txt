 SET(headers
    client.h
    qxmlrpc_documentation.h
    request.h
    response.h
    server.h
    server_private.h
    serverintrospection.h
    stable.h
    variant.h
)

SET(sources
    client.cpp
    request.cpp
    response.cpp
    server.cpp
    serverintrospection.cpp
    variant.cpp
)

QT4_WRAP_CPP(moc_sources ${headers})

ADD_LIBRARY(xmlrpc SHARED ${sources} ${moc_sources} )

INCLUDE(${QT_USE_FILE})

ADD_DEFINITIONS(${QT_DEFINITIONS})

SET(QT_USE_QTXML TRUE)
SET(QT_USE_QTNETWORK TRUE)

TARGET_LINK_LIBRARIES(xmlrpc ${QT_LIBRARIES})

INSTALL_TARGETS(/lib xmlrpc)
INSTALL_FILES(/include/xmlrpc .*\\.h$)

LINK_DIRECTORIES(${CMAKE_BINARY_DIR}/lib)
