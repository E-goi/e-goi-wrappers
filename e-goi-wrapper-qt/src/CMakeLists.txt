SET(headers
    egoi.h
    requesthandler.h
)

SET(sources
    egoi.cpp
    requesthandler.cpp
)

QT4_WRAP_CPP(moc_sources ${headers})

ADD_LIBRARY(egoi SHARED ${sources} ${moc_sources})

INCLUDE(${QT_USE_FILE})

ADD_DEFINITIONS(${QT_DEFINITIONS})

SET(QT_USE_QTXML TRUE)
SET(QT_USE_QTNETWORK TRUE)

TARGET_LINK_LIBRARIES(egoi xmlrpc ${QT_LIBRARIES})

INSTALL_TARGETS(/lib egoi)
INSTALL_FILES(/include/egoi .*\\.h$)

LINK_DIRECTORIES(${CMAKE_BINARY_DIR}/lib)
