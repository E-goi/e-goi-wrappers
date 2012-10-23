/****************************************************************************
** Meta object code from reading C++ file 'server.h'
**
** Created: Wed Oct 17 14:51:43 2012
**      by: The Qt Meta Object Compiler version 63 (Qt 4.8.3)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../xmlrpc/server.h"
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'server.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 63
#error "This file was generated using the moc from 4.8.3. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
static const uint qt_meta_data_xmlrpc__Server[] = {

 // content:
       6,       // revision
       0,       // classname
       0,    0, // classinfo
       5,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: signature, parameters, type, tag, flags
      48,   16,   15,   15, 0x05,

 // slots: signature, parameters, type, tag, flags
     116,  100,   15,   15, 0x0a,
     186,  153,   15,   15, 0x0a,
     213,   15,   15,   15, 0x09,
     241,  229,   15,   15, 0x09,

       0        // eod
};

static const char qt_meta_stringdata_xmlrpc__Server[] = {
    "xmlrpc::Server\0\0requestId,methodName,parameters\0"
    "incomingRequest(int,QString,QList<xmlrpc::Variant>)\0"
    "requestId,value\0sendReturnValue(int,xmlrpc::Variant)\0"
    "requestId,faultCode,faultMessage\0"
    "sendFault(int,int,QString)\0newConnection()\0"
    "data,socket\0processRequest(QByteArray,QTcpSocket*)\0"
};

void xmlrpc::Server::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Q_ASSERT(staticMetaObject.cast(_o));
        Server *_t = static_cast<Server *>(_o);
        switch (_id) {
        case 0: _t->incomingRequest((*reinterpret_cast< int(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2])),(*reinterpret_cast< QList<xmlrpc::Variant>(*)>(_a[3]))); break;
        case 1: _t->sendReturnValue((*reinterpret_cast< int(*)>(_a[1])),(*reinterpret_cast< const xmlrpc::Variant(*)>(_a[2]))); break;
        case 2: _t->sendFault((*reinterpret_cast< int(*)>(_a[1])),(*reinterpret_cast< int(*)>(_a[2])),(*reinterpret_cast< QString(*)>(_a[3]))); break;
        case 3: _t->newConnection(); break;
        case 4: _t->processRequest((*reinterpret_cast< QByteArray(*)>(_a[1])),(*reinterpret_cast< QTcpSocket*(*)>(_a[2]))); break;
        default: ;
        }
    }
}

const QMetaObjectExtraData xmlrpc::Server::staticMetaObjectExtraData = {
    0,  qt_static_metacall 
};

const QMetaObject xmlrpc::Server::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_xmlrpc__Server,
      qt_meta_data_xmlrpc__Server, &staticMetaObjectExtraData }
};

#ifdef Q_NO_DATA_RELOCATION
const QMetaObject &xmlrpc::Server::getStaticMetaObject() { return staticMetaObject; }
#endif //Q_NO_DATA_RELOCATION

const QMetaObject *xmlrpc::Server::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->metaObject : &staticMetaObject;
}

void *xmlrpc::Server::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_xmlrpc__Server))
        return static_cast<void*>(const_cast< Server*>(this));
    return QObject::qt_metacast(_clname);
}

int xmlrpc::Server::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    }
    return _id;
}

// SIGNAL 0
void xmlrpc::Server::incomingRequest(int _t1, QString _t2, QList<xmlrpc::Variant> _t3)
{
    void *_a[] = { 0, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)), const_cast<void*>(reinterpret_cast<const void*>(&_t3)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_END_MOC_NAMESPACE
